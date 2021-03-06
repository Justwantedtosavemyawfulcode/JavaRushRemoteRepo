package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class OriginalZipFileManager {
    // Полный путь zip файла
    private final Path zipFile;

    public OriginalZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void addFiles(List<Path> absolutePathList) throws Exception {
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        Path tempZipFile = Files.createTempFile(null, null);
        List<Path> originalFilesHistoryList = new ArrayList<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile));
             ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempZipFile))) {

            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                zipOutputStream.putNextEntry(zipEntry);
                copyData(zipInputStream, zipOutputStream);
                originalFilesHistoryList.add(Paths.get(zipEntry.getName()));
            }

            for (Path path : absolutePathList) {
                if (!Files.isRegularFile(path)) {
                    throw new PathIsNotFoundException();
                }
                if (!originalFilesHistoryList.contains(path.getFileName())) {
                    zipOutputStream.putNextEntry(new ZipEntry(path.getFileName().toString()));
                    try (InputStream inputStream = Files.newInputStream(path)) {
                        copyData(inputStream, zipOutputStream);
                    }
                    ConsoleHelper.writeMessage("Файл добавлен в архив.");
                }
                if (originalFilesHistoryList.contains(path.getFileName())) {
                    ConsoleHelper.writeMessage("Файл уже есть в архиве.");
                }
            }
        }
        Files.move(tempZipFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
    }

    public void addFile(Path absolutePath) throws Exception {
        addFiles(Collections.singletonList(absolutePath));
    }

    public void removeFiles(List<Path> pathList) throws Exception {
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }
        Path tempZip = Files.createTempFile(zipFile.getParent(), "temp", ".zip");

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile));
             ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempZip))) {

            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (pathList.contains(Paths.get(zipEntry.getName()))) {
                    ConsoleHelper.writeMessage("Файл " + zipEntry.getName() + " удален.");
                }
                else {
                    zipOutputStream.putNextEntry(zipEntry);
                    copyData(zipInputStream, zipOutputStream);
                }

            }
        }

        Files.delete(zipFile);
        Files.move(tempZip, zipFile);
    }

    public void removeFile(Path path) throws Exception {
        List<Path> file = Collections.singletonList(path);
        removeFiles(file);
    }

    public void extractAll(Path outputFolder) throws Exception {
        if (!Files.exists(zipFile)) {
            throw new WrongZipFileException();
        }
        if (!Files.exists(outputFolder)) {
            Files.createDirectories(outputFolder);
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry zipEntry;

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                Path fullFilePath = outputFolder.resolve(zipEntry.getName());
                if (zipEntry.getName().contains("\\") || zipEntry.getName().contains("/")) {
                    String[] directories = zipEntry.getName().split("\\\\|\\/");
                    StringBuilder directoriesWithoutAFile = new StringBuilder();
                    for (int i = 0; i < directories.length - 1; i++) {
                        directoriesWithoutAFile.append(directories[i] + "/");
                    }
                    Files.createDirectories(outputFolder.resolve(directoriesWithoutAFile.toString()));

                }
                copyData(zipInputStream, Files.newOutputStream(fullFilePath));
            }
        }
    }

//    private void extractFileToPath(ZipInputStream zipInputStream, Path path) throws IOException { // Это было лишнее, можно было через copyData
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(path));
//        byte[] bytes = new byte[1024];
//        int count;
//        while ((count = zipInputStream.read(bytes)) != -1) {
//            bufferedOutputStream.write(bytes, 0 , count);
//        }
//    }

    public void createZip(Path source) throws Exception {
        // Проверяем, существует ли директория, где будет создаваться архив
        // При необходимости создаем ее
        Path zipDirectory = zipFile.getParent();
        if (Files.notExists(zipDirectory))
            Files.createDirectories(zipDirectory);

        // Создаем zip поток
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {

            if (Files.isDirectory(source)) {
                // Если архивируем директорию, то нужно получить список файлов в ней
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();

                // Добавляем каждый файл в архив
                for (Path fileName : fileNames)
                    addNewZipEntry(zipOutputStream, source, fileName);

            } else if (Files.isRegularFile(source)) {

                // Если архивируем отдельный файл, то нужно получить его директорию и имя
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else {

                // Если переданный source не директория и не файл, бросаем исключение
                throw new PathIsNotFoundException();
            }
        }
    }

    public List<FileProperties> getFilesList() throws Exception {
        // Проверяем существует ли zip файл
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        List<FileProperties> files = new ArrayList<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                // Поля "размер" и "сжатый размер" не известны, пока элемент не будет прочитан
                // Давайте вычитаем его в какой-то выходной поток
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                copyData(zipInputStream, baos);

                FileProperties file = new FileProperties(zipEntry.getName(), zipEntry.getSize(), zipEntry.getCompressedSize(), zipEntry.getMethod());
                files.add(file);
                zipEntry = zipInputStream.getNextEntry();
            }
        }

        return files;
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        Path fullPath = filePath.resolve(fileName);
        try (InputStream inputStream = Files.newInputStream(fullPath)) {
            ZipEntry entry = new ZipEntry(fileName.toString());

            zipOutputStream.putNextEntry(entry);

            copyData(inputStream, zipOutputStream);

            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}
