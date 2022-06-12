package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        bufferedReader = new BufferedReader(fileReader);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(" ");
        }
        fileReader.close();
        bufferedReader.close();
        String[] tmpWordArray = stringBuilder.toString().split(" ");
        ArrayList<String> wordsArrayList = new ArrayList<String>(Arrays.asList(tmpWordArray));
        for (int i = 0; i < wordsArrayList.size(); i++) {
            String currentWord = wordsArrayList.get(i);
            if (i > 1) {
                if (currentWord.equals(wordsArrayList.get(i - 1))
                        || currentWord.equals(new StringBuilder(wordsArrayList.get(i - 1)).reverse().toString())) {
                    continue;
                }
            }
            for (int j = i + 1; j < wordsArrayList.size(); j++) {
                String checkWord = wordsArrayList.get(j);
                if (new StringBuilder(checkWord).reverse().toString().equals(currentWord)) {
                    Pair pair = new Pair();
                    pair.first = currentWord;
                    pair.second = checkWord;
                    result.add(pair);
                    break;
                }
            }
        }
        for (Pair p:result) {
            System.out.println(p.toString());
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
