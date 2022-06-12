package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.print(c);
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = off; i < off + len; i++) {
            stringBuilder.append(cbuf[i]);
        }
        System.out.print(stringBuilder);
    }


    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        char[] cbuf = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = off; i < off + len; i++) {
            stringBuilder.append(cbuf[i]);
        }
        System.out.print(stringBuilder);
    }


    public void close() throws IOException {
        fileWriter.close();
    }


    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.print(String.valueOf(cbuf));
    }


    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }

    public static void main(String[] args) throws IOException {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("C://Users/leonid/Desktop/1.txt");
        String string = "СТРОКА";
        char[] buf = string.toCharArray();
        fileConsoleWriter.write(buf, 0, 5);
        fileConsoleWriter.write(4);
        fileConsoleWriter.write(string, 1, 4);
        fileConsoleWriter.write(buf);
        fileConsoleWriter.write(string);
        fileConsoleWriter.close();
    }

}
