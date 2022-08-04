package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.ThreadLocalRandom;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 8; i++) {
            char c = (char) ThreadLocalRandom.current().nextInt(48, 123);
            while (!Character.isLetterOrDigit(c)) {
                c = (char) ThreadLocalRandom.current().nextInt(48, 123);
            }
            byteArrayOutputStream.write(c);
        }

        boolean digitIsFound = false;
        boolean letterIsFound = false;
        boolean capitalLetterIsFound = false;
        for (byte b : byteArrayOutputStream.toByteArray()) {
            char c = (char) b;
            if (Character.isDigit(c)) {
                digitIsFound = true;
                continue;
            }
            if (Character.isUpperCase(c)) {
                capitalLetterIsFound = true;
                continue;
            }
            if (Character.isLowerCase(c)) {
                letterIsFound = true;
            }

        }

        if (!(digitIsFound && letterIsFound && capitalLetterIsFound)) {
            byteArrayOutputStream = getPassword();
        }
        return byteArrayOutputStream;
    }
}
