package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));
        FileOutputStream fileOutputStream = new FileOutputStream("C://Users/leonid/Desktop/1.txt");
        FileInputStream fileInputStream = new FileInputStream("C://Users/leonid/Desktop/1.txt");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Object savedObject = new Solution(6);
        objectOutputStream.writeObject(savedObject);

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object loadedObject = objectInputStream.readObject();

        System.out.println(loadedObject);
        System.out.println(savedObject);

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
