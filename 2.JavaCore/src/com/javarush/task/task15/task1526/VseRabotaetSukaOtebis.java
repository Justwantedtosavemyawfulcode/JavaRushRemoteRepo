package com.javarush.task.task15.task1526;

/*
Парсер реквестов
*/

import com.javarush.task.task15.task1527.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VseRabotaetSukaOtebis {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String url = bufferedReader.readLine();
        ArrayList<String> listOfWords = getListOfWords(url);
        ArrayList<String> finalList = parseListOfWords(listOfWords);
        for (String s:finalList) {
            System.out.print(s + " ");
        }
        System.out.println();
        printAlert(objValue);
        //add your code here
    }

    public static ArrayList<String> getListOfWords(String url) {
        char[] charUrlList = url.toCharArray(); // String to char array transition.
        ArrayList<Character> parsedCharsOfUrlList = new ArrayList<>(); // List for "parsed" part of url string. From '?' to the end of a string.
        ArrayList<String> listOfWords = new ArrayList<>();
        boolean parsingIsExecuting = false;
        for (char c : charUrlList) { // Loop for finding '?' character.
            if (c == '?' || c == '&') {
                parsingIsExecuting = true;
                if (parsedCharsOfUrlList.size() > 0) {
                    parsedCharsOfUrlList.remove(0);
                    String word = charToString(parsedCharsOfUrlList);
                    listOfWords.add(word);
                    parsedCharsOfUrlList.clear();
                }
            }
            if (c == '=') {
                parsingIsExecuting ^= true;
                parsedCharsOfUrlList.remove(0);
                String word = charToString(parsedCharsOfUrlList);
                if (word.equals("obj")) {
                    parsingIsExecuting ^= true;
                }
                listOfWords.add(word);
                parsedCharsOfUrlList.clear();
            }
            if (parsingIsExecuting) {
                parsedCharsOfUrlList.add(c);
            }
        }

        return listOfWords;

    }

    public static ArrayList<String> objValue = new ArrayList<>();

    public static ArrayList<String> parseListOfWords(ArrayList<String> listOfWords) {
        String previousString = "";
        for (String s:listOfWords) {
            if (previousString.equals("obj")) {
                VseRabotaetSukaOtebis.objValue.add(s);
                listOfWords.remove(s);
            }
            previousString = s;
        }
        return listOfWords;
    }

    public static void printAlert(ArrayList<String> list) {
        for (String s:list) {
            try {
                double objDouble = Double.parseDouble(s);
                alert(objDouble);
            } catch (NumberFormatException e) {
                alert(s);
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