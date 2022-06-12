package com.javarush.task.task26.task2601;

import java.util.*;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
//        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] array2 = {13, 8, 15, 5, 18};
        Integer[] array3 = {17, 9, 13, 18};
        array2 = sort(array2);
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
    }

    public static Integer[] sort(Integer[] array) {
        Integer[] arr = array;
        int median = findMedian(array);
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(median - o1) - Math.abs(median - o2);
            }
        });
        return arr;






//        List<Integer> sortedList = Arrays.asList(array); //Создаем копию array
//        Collections.sort(sortedList); // Сортируем эту копию
//
//        int median;
//        if (array.length % 2 != 0) {
//            median = sortedList.get(array.length / 2); // Находим медиану
//        }
//        else {
//            median = ((sortedList.get(array.length / 2) + sortedList.get(array.length / 2 - 1)) / 2);
//        }
//
//        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>(); // Создаем сортированную мапу с ключами по удаленности и значениями Инт
//
//        for (int i = 0; i < array.length; i++) {               // Добавляем все инты по значению удаленности
//            int remoteness = Math.abs(median - sortedList.get(i));
//            if (!(map.containsKey(remoteness))) {   // Если в мапе еще нету такой удаленности то создаем новый список и добавляем в мапу
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(sortedList.get(i));
//                map.put(remoteness, list);
//            }
//            else {   // Если уже есть такой ключ удаленности то добавляем значение в новый список и меняем список ключа
//                ArrayList<Integer> list = new ArrayList<>(map.get(remoteness));
//                list.add(sortedList.get(i));
//                Collections.sort(list);
//                map.put(remoteness, list);
//            }
//        }
//
//        Integer[] resultArray = new Integer[array.length];
//
//        int i = 0;
//        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {  // Заполняем возвращаемый массив
//            for (Integer n : entry.getValue()) {
//                resultArray[i] = n;
//                i++;
//            }
//        }
//        //implement logic here
//        return resultArray;
    }


    public static int findMedian(Integer[] array) {
        ArrayList<Integer> sortedList = new ArrayList<Integer>(Arrays.asList(array));
        Collections.sort(sortedList);
        int median;
        if (array.length % 2 != 0) {
            median = sortedList.get(array.length / 2); // Находим медиану
        } else {
            median = ((sortedList.get(array.length / 2) + sortedList.get(array.length / 2 - 1)) / 2);
        }
        return median;
    }
}
