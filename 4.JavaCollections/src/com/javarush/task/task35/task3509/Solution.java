package com.javarush.task.task35.task3509;

import java.util.*;

/* 
Collections & Generics
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (Object element : elements) {
            arrayList.add((T) element);
        }
        //напишите тут ваш код
        return arrayList;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> hashSet = new HashSet<>();
        for (Object element : elements) {
            hashSet.add((T) element);
        }
        //напишите тут ваш код
        return hashSet;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) throws IllegalAccessException {
        HashMap<K, V> hashMap = new HashMap<>();
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < keys.size(); i++) {
            hashMap.put(keys.get(i), values.get(i));
        }
        //напишите тут ваш код
        return hashMap;
    }
}
