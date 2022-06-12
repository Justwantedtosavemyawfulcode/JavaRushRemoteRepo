package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if ((string == null) || (string.lastIndexOf("\t") == string.indexOf("\t"))) {
            throw new TooShortStringException();
        }
        else {
//            return string.substring(string.indexOf("\t"), string.indexOf(string.substring(string.indexOf("\t") + 1)));
            String s = string.substring(string.indexOf("\t") + 1);
            String s1 = s.substring(0, s.indexOf("\t"));
            return s1;
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
