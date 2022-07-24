package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> returningList = new ArrayList<>();
        Queue<File> queue = new LinkedList<File>();
        queue.add(new File(root));
        while (queue.peek() != null) {
            File directory = queue.poll();
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    queue.add(file);
                }
                else {
                    returningList.add(file.getAbsolutePath());
                }
            }
        }
        return returningList;
    }

    public static void main(String[] args) throws IOException {
        for (String s : getFileTree("C:\\Musor")) {
            System.out.println(s);
        }
    }
}
