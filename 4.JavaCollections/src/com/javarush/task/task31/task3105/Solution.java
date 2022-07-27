package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        String zipName = args[1];
        File zip = new File(zipName);
        ArrayList<Content> contentList = new ArrayList<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zip.toPath()))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            while (zipEntry != null) {
                byte[] buffer = new byte[2048];
                int length = 0;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while ((length = zipInputStream.read(buffer)) > 0) {
                    byteArrayOutputStream.write(buffer, 0, length);
                }
                contentList.add(new Content(zipEntry.getName(), byteArrayOutputStream.toByteArray()));
                zipInputStream.closeEntry();
                zipEntry = zipInputStream.getNextEntry();
            }
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zip.toPath()))) {
            boolean fileWithTheSameNameWasWritten = false;
            for (Content content : contentList) {
                if (content.name.equals(file.getName())) {
                    zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                    Files.copy(file.toPath(), zipOutputStream);
                    zipOutputStream.closeEntry();
                    fileWithTheSameNameWasWritten = true;
                }
                else {
                    zipOutputStream.putNextEntry(new ZipEntry(content.name));
                    zipOutputStream.write(content.data);
                    zipOutputStream.closeEntry();
                }
            }
            if (!fileWithTheSameNameWasWritten) {
                zipOutputStream.putNextEntry(new ZipEntry("new/" + file.getName()));
                Files.copy(file.toPath(), zipOutputStream);
                zipOutputStream.closeEntry();
            }
        }
    }

    public static class Content {
    String name;
    byte[] data;

        public Content(String name, byte[] data) {
            this.name = name;
            this.data = data;
        }
    }
}
