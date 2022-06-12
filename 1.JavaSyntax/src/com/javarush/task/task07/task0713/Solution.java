package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> inputList = new ArrayList<>();
        ArrayList<Integer> threeList = new ArrayList<>();
        ArrayList<Integer> twoList = new ArrayList<>();
        ArrayList<Integer> otherList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            int s = Integer.parseInt(bufferedReader.readLine());
            inputList.add(s);
        }
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i) % 3 == 0 || inputList.get(i) % 2 == 0) {
                if (inputList.get(i) % 3 == 0) {
                    threeList.add(inputList.get(i));
                }
                if (inputList.get(i) % 2 == 0) {
                    twoList.add(inputList.get(i));
                }
            }
            else {
                otherList.add(inputList.get(i));
            }
        }
        printList(threeList);
        printList(twoList);
        printList(otherList);
        //напишите тут ваш код
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //напишите тут ваш код
    }
}
