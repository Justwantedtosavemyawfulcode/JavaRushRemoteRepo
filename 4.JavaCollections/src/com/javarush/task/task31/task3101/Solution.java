package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<String> listOfFiles = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        String newFileOutputName = new File(resultFileAbsolutePath.getParent() + "\\allFilesContent.txt").getAbsolutePath();
        if (FileUtils.isExist(resultFileAbsolutePath)) {
            FileUtils.renameFile(resultFileAbsolutePath, new File(resultFileAbsolutePath.getParent() + "\\allFilesContent.txt"));
        }

        getFilesFromDirectory(path);

        FileOutputStream outputStream = new FileOutputStream(newFileOutputName);
        for (String fileAbsolutePath : listOfFiles) {
            try (FileInputStream inputStream = new FileInputStream(fileAbsolutePath)) {

                byte[] buffer = new byte[(int) new File(fileAbsolutePath).length()];
                int count = inputStream.read(buffer);
                outputStream.write(buffer);
                outputStream.write(10);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getFilesFromDirectory(File path) {
        for (File file : path.listFiles()) {
            if (!file.isDirectory()) {
                if (file.length() <= 50) {
                    listOfFiles.add(file.getAbsolutePath());
                }
            } else getFilesFromDirectory(file);
        }
    }
}
