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
    int numberOfDirectories = -1;
    int numberOfFiles = 0;
    long amountOfBytes = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String stringPath = bufferedReader.readLine();
        Path path = Paths.get(stringPath);
        if (Files.isDirectory(path)) {
            Solution solution = new Solution();
            Files.walkFileTree(path, solution);

            System.out.println("Всего папок - " + solution.numberOfDirectories);
            System.out.println("Всего файлов - " + solution.numberOfFiles + solution.numberOfDirectories);
            System.out.println("Общий размер - " + solution.amountOfBytes);
        }

        else System.out.println(stringPath + " - не папка");

    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isRegularFile(file)) {
            numberOfFiles++;
            amountOfBytes += Files.readAllBytes(file).length;
        }
        else numberOfDirectories++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        numberOfDirectories++;
        return FileVisitResult.CONTINUE;
    }
}