package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        testString.printSomething();

        String line = byteArrayOutputStream.toString();
        String[] lineArray = line.split(" ");

        System.setOut(console);

        if (lineArray[1].equals("+")) {
            System.out.println(lineArray[0] + " " + lineArray[1] + " " + lineArray[2] + " = " + (Integer.parseInt(lineArray[0]) + Integer.parseInt(lineArray[2])));
        }
        if (lineArray[1].equals("-")) {
            System.out.println(lineArray[0] + " " + lineArray[1] + " " + lineArray[2] + " = " + (Integer.parseInt(lineArray[0]) - Integer.parseInt(lineArray[2])));
        }
        if (lineArray[1].equals("*")) {
            System.out.println(lineArray[0] + " " + lineArray[1] + " " + lineArray[2] + " = " + (Integer.parseInt(lineArray[0]) * Integer.parseInt(lineArray[2])));
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

