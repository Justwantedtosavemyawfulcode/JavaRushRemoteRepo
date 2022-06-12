package com.javarush.task.task15.task1526;

/*
Парсер реквестов
*/

import java.io.IOException;
import java.util.ArrayList;

public class BetaSolution {
    public static void main(String[] args) throws IOException {
        String url = "l?obj=jopa&name=Amigo"; // !Add buffered reader after debug.!
        ArrayList<String> listOfWords = getListOfWords(url);
        parseListOfWords(listOfWords);
        //add your code here
    }

    public static ArrayList<String> getListOfWords(String url) {
        char[] charUrlList = url.toCharArray(); // String to char array transition.
        ArrayList<Character> parsedCharsOfUrlList = new ArrayList<>(); // List for "parsed" part of url string. From '?' to the end of a string.
        ArrayList<String> listOfWords = new ArrayList<>();
        boolean parsingIsExecuting = false;
        for (char c : charUrlList) { // Loop for finding '?' character.
            if (c == '?' || c == '&' || c == '=') {
                parsingIsExecuting = true;
                if (parsedCharsOfUrlList.size() > 0) {
                    parsedCharsOfUrlList.remove(0);
                    String word = charToString(parsedCharsOfUrlList);
                    listOfWords.add(word);
                    parsedCharsOfUrlList.clear();
                }
            }
            if (parsingIsExecuting) {
                parsedCharsOfUrlList.add(c);
            }
        }

        return listOfWords;

    }

    public static void parseListOfWords(ArrayList<String> listOfWords) {
        for (int i = 0; i < listOfWords.size(); i++) {
            if (listOfWords.get(i).equals("obj")) {
                String objValue = listOfWords.get(i + 1);
                try {
                    double objDouble = Double.parseDouble(objValue);
                    alert(objDouble);
                }
                catch (NumberFormatException e) {
                    alert(objValue);
                }
            }
        }
    }

    public static String charToString(ArrayList<Character> lst) {
        StringBuilder builder = new StringBuilder();
        for (char c:lst) {
            builder.append(c);
        }
        return builder.toString();
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
