package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Paths;/*
Null Object Pattern
*/

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        boolean hidden;
        boolean executable;
        boolean directory;
        boolean writable;
        try {
            hidden = Files.isHidden(Paths.get(pathToFile));
            executable = Files.isExecutable(Paths.get(pathToFile));
            directory = Files.isDirectory(Paths.get(pathToFile));
            writable = Files.isWritable(Paths.get(pathToFile));
            fileData = new ConcreteFileData(hidden, executable, directory, writable);
        }
        catch (Exception e) {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
