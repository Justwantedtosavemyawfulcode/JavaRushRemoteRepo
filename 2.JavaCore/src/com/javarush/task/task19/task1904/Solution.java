package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import com.sun.java_cup.internal.runtime.Symbol;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(new FileReader("C://Users/leonid/Desktop/1.txt"));
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(scanner);
        System.out.println(personScannerAdapter.read());

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String stringPerson = fileScanner.nextLine();
            String[] arrayPerson = stringPerson.split(" ");
            String firstName = arrayPerson[1];
            String middleName = arrayPerson[2];
            String lastName = arrayPerson[0];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            String stringBuilder = arrayPerson[3] + " " +
                    arrayPerson[4] + " " +
                    arrayPerson[5] + " ";
            Date date = simpleDateFormat.parse(stringBuilder);
            return new Person(firstName, middleName, lastName, date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }

    }
}
