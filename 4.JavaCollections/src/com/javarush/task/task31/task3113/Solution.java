package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/

public class Solution extends SimpleFileVisitor<Path> {
    int numberOfDirectories = 0;
    int numberOfFiles = 0;
    long amountOfBytes = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String stringPath = bufferedReader.readLine();
        Path path = Paths.get(stringPath);
        if (!Files.isDirectory(path)) {
            System.out.println(stringPath + " - не папка");
            System.exit(0);
        }

        Solution solution = new Solution();
        Files.walkFileTree(path, solution);

        System.out.println("Всего папок - " + solution.numberOfDirectories);
        System.out.println("Всего файлов - " + solution.numberOfFiles);
        System.out.println("Общий размер - " + solution.amountOfBytes);

    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isRegularFile(file)) {
            try (FileInputStream fileInputStream = new FileInputStream(file.toString())) {
                numberOfFiles++;
                amountOfBytes += fileInputStream.available();
            }
        }
        else numberOfDirectories++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        numberOfDirectories++;
        return FileVisitResult.CONTINUE;
    }
}
