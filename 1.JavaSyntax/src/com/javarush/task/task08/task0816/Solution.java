package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Петров", dateFormat.parse("JANUARY 4 1978"));
        map.put("Баширов", dateFormat.parse("JUNE 1 2012"));
        map.put("Путин", dateFormat.parse("MAY 1 2012"));
        map.put("Сталин", dateFormat.parse("JULY 1 2012"));
        map.put("Христос", dateFormat.parse("AUGUST 1 2012"));
        map.put("Аллах", dateFormat.parse("MAY 1 2012"));
        map.put("Чингачгук", dateFormat.parse("MAY 1 2012"));
        map.put("Старых", dateFormat.parse("MAY 1 2012"));
        map.put("Беня", dateFormat.parse("MARCH 1 2012"));
        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            Date newDate = pair.getValue();
            int month = newDate.getMonth();
            if (month == 5 || month == 6 || month == 7) {
                iterator.remove();
            }
        }
        //напишите тут ваш код

    }

    public static void main(String[] args) throws ParseException {
        Map<String, Date> map = createMap();
        removeAllSummerPeople(map);
    }
}
