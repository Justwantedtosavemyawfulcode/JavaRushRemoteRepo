package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        create(args[i], args[i + 1], args[i + 2]);
                    }
                }
                break;

            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        update(Integer.parseInt(args[i]), args[i + 1], args[i + 2], args[i + 3]);
                    }
                }
                break;

            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        delete(Integer.parseInt(args[i]));
                    }
                }
                break;

            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        showIdInfo(Integer.parseInt(args[i]));
                    }
                }
                break;
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
        //start here - начни тут
}
