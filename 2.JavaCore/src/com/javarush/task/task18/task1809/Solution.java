package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath1 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String filePath2 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream fileInputStream = new FileInputStream(filePath1);
        FileOutputStream fileOutputStream = new FileOutputStream(filePath2);
        byte[] arr = new byte[fileInputStream.available()];
        int count = fileInputStream.read(arr);
        ArrayList<Byte> list = new ArrayList<>();
        for (Byte b:arr) {
            list.add(b);
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        fileOutputStream.write(arr, 0, count);
        fileInputStream.close();
        fileOutputStream.close();

    }
}
