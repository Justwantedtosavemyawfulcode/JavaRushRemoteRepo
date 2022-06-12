package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()) {
            String[] tmpArray = bufferedReader.readLine().split(" ");
            list.addAll(Arrays.asList(tmpArray));
        }
        fileReader.close();
        bufferedReader.close();
        StringBuilder result = getLine(getSortedWords(list));
        System.out.println(result.toString());
    }

    public static String[] getSortedWords(List<String> list) {
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<>();
        ArrayList<String> sortedList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            sortedList = sortList((ArrayList<String>) list, i);
            listOfLists.add(sortedList);
        }
        int maxSize = 0;
        for (ArrayList<String> l:listOfLists) {
            if (l.size() > maxSize) {
                maxSize = l.size();
            }
        }
        for (ArrayList<String> l:listOfLists) {
            if (l.size() == maxSize) {
                sortedList = l;
            }
        }
        String[] wordsArray = new String[sortedList.size()];
        return sortedList.toArray(wordsArray);
    }

    public static ArrayList<String> sortList(ArrayList<String> list, int wordIndex) {
        ArrayList<String> sortedList = new ArrayList<>();
//        sortedList.add(list.get(getRandomNumber(0, list.size()))); There used to be choosing of random first word.
        sortedList.add(list.get(wordIndex)); // Now first word is picked by a loop.
        boolean wordAddedFlag = true;
        while (sortedList.size() != list.size()) {
            if (!wordAddedFlag) {
                break;
            }
            wordAddedFlag = false;
            for (int i = 0; i < list.size(); i++) {
                String currentString = list.get(i);
                if (!(sortedList.contains(currentString))) {
                    String lastWord = sortedList.get(sortedList.size() - 1).toLowerCase();
                    char lastChar = lastWord.charAt(sortedList.get(sortedList.size() - 1).length() - 1);
                    String tmpCurrentWord = currentString.toLowerCase();
                    char firstChar = tmpCurrentWord.charAt(0);
                    if (firstChar == lastChar) {
                        sortedList.add(currentString);
                        wordAddedFlag = true;
                        break;
                    }
                }
            }
        }
//        char lastChar = sortedList.get(sortedList.size() - 1).charAt(sortedList.get(sortedList.size() - 1).length() - 1);
//        String tmpCurrentString = sortedList.get(0).toLowerCase();
//        char firstChar = tmpCurrentString.charAt(0);
//        if (firstChar != lastChar) {
//            sortedList = sortList(sortedList);
//        }
        return sortedList;
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:words) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(s);
        }
        return stringBuilder;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
