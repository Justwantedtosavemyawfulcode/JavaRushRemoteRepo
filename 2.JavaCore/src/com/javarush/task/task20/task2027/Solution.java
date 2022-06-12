package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword,  "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> listOfWords = new ArrayList<>();
        for (String s:words) {
            Word currentWord = new Word(s);
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[0].length; j++) {
                    if (crossword[i][j] == s.charAt(0)) {
                        // horizontal right direction
                        for (int k = 1; k < s.length(); k++) {
                            try {
                                if (!(crossword[i][j + k] == s.charAt(k))) {
                                    break;
                                } else {
                                    if (k == s.length() - 1) {
                                        currentWord.startX = j;
                                        currentWord.startY = i;
                                        currentWord.endX = j + k;
                                        currentWord.endY = i;
                                    }
                                }
                            }
                            catch (ArrayIndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // horizontal left direction
                        for (int k = 1; k < s.length(); k++) {
                            try {
                                if (!(crossword[i][j - k] == s.charAt(k))) {
                                    break;
                                } else {
                                    if (k == s.length() - 1) {
                                        currentWord.startX = j;
                                        currentWord.startY = i;
                                        currentWord.endX = j - k;
                                        currentWord.endY = i;
                                    }
                                }
                            }
                            catch (ArrayIndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // vertical down direction
                        for (int k = 1; k < s.length(); k++) {
                            try {
                                if (!(crossword[i + k][j] == s.charAt(k))) {
                                    break;
                                } else {
                                    if (k == s.length() - 1) {
                                        currentWord.startX = j;
                                        currentWord.startY = i;
                                        currentWord.endX = j;
                                        currentWord.endY = i + k;
                                    }
                                }
                            }
                            catch (ArrayIndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // vertical up direction
                        for (int k = 1; k < s.length(); k++) {
                            try {
                                if (!(crossword[i - k][j] == s.charAt(k))) {
                                    break;
                                } else {
                                    if (k == s.length() - 1) {
                                        currentWord.startX = j;
                                        currentWord.startY = i;
                                        currentWord.endX = j;
                                        currentWord.endY = i - k;
                                    }
                                }
                            }
                            catch (ArrayIndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // diagonal down right direction
                        for (int k = 1; k < s.length(); k++) {
                            try {
                                if (!(crossword[i + k][j + k] == s.charAt(k))) {
                                    break;
                                } else {
                                    if (k == s.length() - 1) {
                                        currentWord.startX = j;
                                        currentWord.startY = i;
                                        currentWord.endX = j + k;
                                        currentWord.endY = i + k;
                                    }
                                }
                            }
                            catch (ArrayIndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // diagonal up right direction
                        for (int k = 1; k < s.length(); k++) {
                            try {
                                if (!(crossword[i - k][j + k] == s.charAt(k))) {
                                    break;
                                } else {
                                    if (k == s.length() - 1) {
                                        currentWord.startX = j;
                                        currentWord.startY = i;
                                        currentWord.endX = j + k;
                                        currentWord.endY = i - k;
                                    }
                                }
                            }
                            catch (ArrayIndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // diagonal down left direction
                        for (int k = 1; k < s.length(); k++) {
                            try {
                                if (!(crossword[i + k][j - k] == s.charAt(k))) {
                                    break;
                                } else {
                                    if (k == s.length() - 1) {
                                        currentWord.startX = j;
                                        currentWord.startY = i;
                                        currentWord.endX = j - k;
                                        currentWord.endY = i + k;
                                    }
                                }
                            }
                            catch (ArrayIndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // diagonal up left direction
                        for (int k = 1; k < s.length(); k++) {
                            try {
                                if (!(crossword[i - k][j - k] == s.charAt(k))) {
                                    break;
                                } else {
                                    if (k == s.length() - 1) {
                                        currentWord.startX = j;
                                        currentWord.startY = i;
                                        currentWord.endX = j - k;
                                        currentWord.endY = i - k;
                                    }
                                }
                            }
                            catch (ArrayIndexOutOfBoundsException e) {
                                break;
                            }
                        }
                    }
                }
            }
            listOfWords.add(currentWord);
        }
        
        return listOfWords;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
