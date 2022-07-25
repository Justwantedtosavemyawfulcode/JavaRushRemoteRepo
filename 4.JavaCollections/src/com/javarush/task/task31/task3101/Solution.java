package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File newFileOutputName = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        if (FileUtils.isExist(newFileOutputName)) {
            FileUtils.deleteFile(newFileOutputName);
        }
        FileUtils.renameFile(resultFileAbsolutePath, newFileOutputName);

        try (FileOutputStream fileOutputStream = new FileOutputStream(newFileOutputName)) {

            Queue<File> queue = new LinkedList<File>();
            queue.add(path);
            while (queue.peek() != null) {
                File directory = queue.poll();
                for (File file : directory.listFiles()) {
                    if (file.isDirectory()) {
                        queue.add(file);
                    } else {
                        if (file.length() <= 50) {
                            try (FileInputStream inputStream = new FileInputStream(file)) {

                                byte[] buffer = new byte[(int) file.length()];
                                int count = inputStream.read(buffer);
                                fileOutputStream.write(buffer);
                                fileOutputStream.write("\n".getBytes());
                            }
                        }
                    }
                }
            }
        }
    }
}

//        FileOutputStream outputStream = new FileOutputStream(newFileOutputName);
//        for (String fileAbsolutePath : listOfFiles) {
//            try (FileInputStream inputStream = new FileInputStream(fileAbsolutePath)) {
//
//                byte[] buffer = new byte[(int) new File(fileAbsolutePath).length()];
//                int count = inputStream.read(buffer);
//                outputStream.write(buffer);
//                outputStream.write(10);
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    public static void getFilesFromDirectory(File path) {
//        for (File file : path.listFiles()) {
//            if (!file.isDirectory()) {
//                if (file.length() <= 50) {
//                    listOfFiles.add(file.getAbsolutePath());
//                }
//            } else getFilesFromDirectory(file);
//        }
//    }


//    public static void writeFromOneFileToAnother(File origin, File destination) throws IOException {
//        for (File file : origin.listFiles()) {
//            if (!file.isDirectory()) {
//                if (file.length() <= 50) {
//                    FileInputStream inputStream = new FileInputStream(file);
//                    FileOutputStream outputStream = new FileOutputStream(destination, true);
//
//                    byte[] buffer = new byte[(int) file.length()];
//                    int count = inputStream.read(buffer);
//                    outputStream.write(buffer);
//                    outputStream.write(10);
//                    inputStream.close();
//                    outputStream.close();
//
//                }
//            }
//            else writeFromOneFileToAnother(file, destination);
//        }
//    }
