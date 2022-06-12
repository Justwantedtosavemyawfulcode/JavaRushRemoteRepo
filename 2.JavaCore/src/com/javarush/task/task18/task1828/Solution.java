package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        String filePath = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int maxID = 0;

        if (args.length == 0) {
            return;
        }
        else if (args[0].equals("-u")) {
            ArrayList<String> tempFileContent = new ArrayList<>();
            int updatableID = Integer.parseInt(args[1]);
            String line = bufferedReader.readLine();
            while (line != null) {
                int currentID = Integer.parseInt(line.substring(0, 8).trim());
                if (currentID == updatableID) {
                    tempFileContent.add(String.format("%-8d%-30.30s%-8.2f%-4.4s", currentID, args[2], Float.parseFloat(args[3]), args[4]));
                }
                else {
                    tempFileContent.add(line);
                }
                line = bufferedReader.readLine();
            }
            FileWriter fileWriter = new FileWriter(filePath);
            for (String s:tempFileContent) {
                fileWriter.write(String.format("%s%n", s));
            }
            fileWriter.close();
        }
        else if (args[0].equals("-d")) {
            ArrayList<String> tempFileContent = new ArrayList<>();
            String line = bufferedReader.readLine();
            int deletableID = Integer.parseInt(args[1]);
            while (line != null) {
                int currentID = Integer.parseInt(line.substring(0, 8).trim());
                if (currentID != deletableID) {
                    tempFileContent.add(line);
                }
                line = bufferedReader.readLine();
            }
            FileWriter fileWriter = new FileWriter(filePath);
            for (String s:tempFileContent) {
                fileWriter.write(String.format("%s%n", s));
            }
            fileWriter.close();
        }
        bufferedReader.close();

        //String result = String.format("%n%-8d%-30.30s%-8.2f%-4.4s", maxID, args[1], Float.parseFloat(args[2]), args[3]);
        //System.out.println(result);
        //fileWriter.write(result);

    }
}
