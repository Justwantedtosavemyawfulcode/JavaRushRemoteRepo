package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
        ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
        zipOutputStream.putNextEntry(zipEntry);

        try (InputStream fileInputStream = Files.newInputStream(source)) {
            byte[] inBytes = new byte[1000];
            while (fileInputStream.available() > 0) {
                int count = fileInputStream.read(inBytes);
                zipOutputStream.write(inBytes, 0, count);
            }
        }
        zipOutputStream.closeEntry();
        }
    }

}
