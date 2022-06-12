package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        if (args[0].equals("-c")) {
            create(args[1], args[2], args[3]);
        }
        if (args[0].equals("-u")) {
            update(Integer.parseInt(args[1]), args[2], args[3], args[4]);
        }
        if (args[0].equals("-d")) {
            delete(Integer.parseInt(args[1]));
        }
        if (args[0].equals("-i")) {
            showIdInfo(Integer.parseInt(args[1]));
        }

        //start here - начни тут
    }

    public static void create(String name, String sex, String date) throws ParseException {
        Date newDate = new SimpleDateFormat("d/MM/yyyy").parse(date);
        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, newDate));
        }
        if (sex.equals("ж")) {
            allPeople.add(Person.createFemale(name, newDate));
        }
        System.out.println(allPeople.size() - 1);
    }

    public static void update(int id, String name, String sex, String date) throws ParseException {
        Date newDate = new SimpleDateFormat("d/MM/yyyy").parse(date);
        if (sex.equals("м")) {
            allPeople.set(id, Person.createMale(name, newDate));
        }
        if (sex.equals("ж")) {
            allPeople.set(id, Person.createFemale(name, newDate));
        }
    }

    public static void delete(int id) {
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDate(null);
    }

    public static void showIdInfo(int id) {
        System.out.println(allPeople.get(id));
    }
}
