package com.javarush.task.task16.task1630;


import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Save {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = bufferedReader.readLine();
            secondFileName = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private String fileText = "";

        @Override
        public void setFileName(String fullFileName) {
            fileName = fullFileName;

        }

        @Override
        public String getFileContent() {
            return fileText;
        }

        @Override
        public void run() {
            try {
                Scanner scanner = new Scanner(Paths.get(fileName));
                StringBuilder stringBuilder = new StringBuilder();
                while (scanner.hasNext()) {
                    stringBuilder.append(scanner.next() + " ");
                }
                fileText = stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
                scanner.close();
            } catch (FileNotFoundException e) {
                e.getStackTrace();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    //add your code here - добавьте код тут
}