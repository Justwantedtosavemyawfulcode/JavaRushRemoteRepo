package com.javarush.task.task18.task1813;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    private FileOutputStream fileOutputStream;

    public AmigoOutputStream(FileOutputStream f) throws IOException {
        super(f.getFD());
        this.fileOutputStream = f;
    }
    public static String fileName = "C:/tmp/result.txt";

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.flush();
        String j = "JavaRush © All rights reserved.";
        byte[] bytes = j.getBytes();
        this.write(bytes);
        fileOutputStream.close();

    }

    public static void main(String[] args) throws IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
