package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader filePath1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader originalFile = new BufferedReader(new FileReader(filePath1.readLine()));
        filePath1.close();
        BufferedReader filePath2= new BufferedReader(new InputStreamReader(System.in));
        BufferedReader editedFile = new BufferedReader(new FileReader(filePath2.readLine()));
        filePath2.close();

        ArrayList<String> textFile1 = new ArrayList<>();
        while (originalFile.ready()) {
            textFile1.add(originalFile.readLine());
        }
        originalFile.close();

        ArrayList<String> textFile2 = new ArrayList<>();
        while (editedFile.ready()) {
            textFile2.add(editedFile.readLine());
        }
        editedFile.close();

        int i;

        for (i = 0; i < textFile1.size(); i++) {
            if (textFile2.contains(textFile1.get(i))) {
                lines.add(new LineItem(Type.SAME, textFile1.get(i)));
            }
            else {
                lines.add(new LineItem(Type.REMOVED, textFile1.get(i)));
            }
            try {
                if (!(textFile1.contains(textFile2.get(i)))) {
                    lines.add(new LineItem(Type.ADDED, textFile2.get(i)));
                }
            }
            catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        if (textFile2.size() > textFile1.size()) {
            for (int j = i; j < textFile2.size(); j++) {
                if (!(textFile1.contains(textFile2.get(j)))) {
                    lines.add(new LineItem(Type.ADDED, textFile2.get(j)));
                }
            }
        }

        for (int j = 0; j < lines.size() - 2; j++) {
            if (lines.get(j).type.equals(Type.SAME) && lines.get(j + 1).type.equals(Type.SAME)) {
                LineItem tmp = lines.get(j + 1);
                lines.set(j + 1, lines.get(j + 2));
                lines.set(j + 2, tmp);
            }
        }
        for (int j = 0; j < lines.size() - 3; j++) {
            if (lines.get(j).type.equals(Type.SAME) && lines.get(j + 3).type.equals(Type.SAME)) {
                LineItem tmp = lines.get(j + 2);
                lines.set(j + 2, lines.get(j + 3));
                lines.set(j + 3, tmp);
            }
        }

        for (LineItem l:lines) {
            System.out.println(l);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type.toString() + " " + line;  // УДАЛИТЬ
        }
    }
}