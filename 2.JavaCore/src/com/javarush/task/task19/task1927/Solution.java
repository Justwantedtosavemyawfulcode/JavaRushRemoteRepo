package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newOutputStream = new PrintStream(byteArrayOutputStream);
        System.setOut(newOutputStream);

        testString.printSomething();

        String[] output = byteArrayOutputStream.toString().split("\\n");

        System.setOut(console);

        for (int i = 0; i < output.length; i++) {
            if (i % 2 == 0 && i != 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
            System.out.println(output[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
