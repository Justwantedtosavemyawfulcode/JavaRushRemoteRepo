package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String str;
        while ((str = fileReader.readLine()) != null) {
            String[] strings = str.split(" ");
            StringBuilder stringBuilderName = new StringBuilder();
            for (String s:strings) {
                try {
                    Integer.parseInt(s);
                }
                catch (NumberFormatException e) {
                    stringBuilderName.append(s).append(" ");
                }
            }
            String name = stringBuilderName.toString().trim();
            StringBuilder stringBuilderDate = new StringBuilder();
            stringBuilderDate.append(strings[strings.length - 3]).append(" ").append(strings[strings.length - 2]).append(" ").append(strings[strings.length - 1]);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            Date date = simpleDateFormat.parse(stringBuilderDate.toString());
            PEOPLE.add(new Person(name, date));
        }
        fileReader.close();
//        System.out.println(PEOPLE);
    }
}
