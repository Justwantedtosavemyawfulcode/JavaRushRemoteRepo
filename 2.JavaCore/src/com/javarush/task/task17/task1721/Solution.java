package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        String file1Path = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String file2Path = new BufferedReader(new InputStreamReader(System.in)).readLine();
        BufferedReader file1 = new BufferedReader(new FileReader(file1Path));
        BufferedReader file2 = new BufferedReader(new FileReader(file2Path));
        String temp;
        while ((temp = file1.readLine()) != null) {
            allLines.add(temp);
        }
        while ((temp = file2.readLine()) != null) {
            forRemoveLines.add(temp);
        }

        Solution solution = new Solution();
        solution.joinData();

//        System.out.println(allLines);
//        System.out.println(forRemoveLines);
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
