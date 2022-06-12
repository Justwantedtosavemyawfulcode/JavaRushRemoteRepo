package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private static final long serialVersionUID = 8749597499284057773L;
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("C://Users/leonid/Desktop/1.txt");
        solution.writeObject("test");
        FileOutputStream fileOutputStream = new FileOutputStream("C://Users/leonid/Desktop/2.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(solution);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C://Users/leonid/Desktop/2.txt"));
        objectInputStream.readObject();
        solution.writeObject("file2");
    }
}
