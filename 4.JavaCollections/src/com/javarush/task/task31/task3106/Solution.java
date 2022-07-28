package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        Path resultFile = Paths.get(args[0]);
        List<String> stringZipParts = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            stringZipParts.add(args[i]);
        }

        Collections.sort(stringZipParts);

        List<FileInputStream> zipParts = new ArrayList<>();
        for (String path : stringZipParts) {
            zipParts.add(new FileInputStream(path));
        }
        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(zipParts));

        ZipInputStream zipInputStream = new ZipInputStream(sequenceInputStream);
        OutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(resultFile.toString()));
        byte[] buffer = new byte[4096];
        int length;
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            while ((length = zipInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, length);
            }
            fileOutputStream.flush();
        }
        zipInputStream.close();
        fileOutputStream.close();
    }
}
