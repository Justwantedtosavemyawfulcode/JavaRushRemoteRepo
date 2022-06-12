package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String filePath = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileReader fileReader = new FileReader(filePath);
        FileWriter fileWriter = new FileWriter(filePath, true);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int maxID = 0;

        if (args.length == 0) {
            return;
        }
        else if (args[0].equals("-c")) {
            try {
                String line = bufferedReader.readLine();
                while (!(line.length() == 0)) {
                    int currentID = Integer.parseInt(line.substring(0, 8).trim());
                    if (currentID > maxID) {
                        maxID = currentID;
                    }
                    line = bufferedReader.readLine();
                }
            }
            catch (NullPointerException e) {
                maxID++;
            }
        }
        bufferedReader.close();

        String result = String.format("%n%-8d%-30.30s%-8.2f%-4.4s", maxID, args[1], Float.parseFloat(args[2]), args[3]);
        //System.out.println(result);
        fileWriter.write(result);
        fileWriter.close();


    }
}
