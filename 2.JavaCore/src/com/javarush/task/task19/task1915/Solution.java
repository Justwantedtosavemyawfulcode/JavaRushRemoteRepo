package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream(bufferedReader.readLine());
        bufferedReader.close();

        PrintStream console = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        testString.printSomething();

        String line = byteArrayOutputStream.toString();

        fileOutputStream.write(line.getBytes());
        fileOutputStream.close();

        System.setOut(console);
        System.out.println(line);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

