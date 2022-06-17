package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите полный путь до архива:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(bufferedReader.readLine()));

        System.out.println("Введите полный путь до файла, который нужно архивировать:");
        zipFileManager.createZip(Paths.get(bufferedReader.readLine()));

        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();

    }
}
