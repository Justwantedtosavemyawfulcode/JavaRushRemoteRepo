package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
*/
public class Solution implements Serializable {
    private static final long serialVersionUID = 4701484924029864189L;

    public static class A {

        protected String nameA = "A";

        public A() {

        }

        public A(String nameA) {
            this.nameA += nameA;
        }
    }

    public class B extends A implements Serializable {

        private static final long serialVersionUID = -3957660428334667578L;
        private String nameB;


        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(super.nameA);
            objectOutputStream.defaultWriteObject();
            objectOutputStream.flush();
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            super.nameA = (String) objectInputStream.readObject();
            objectInputStream.defaultReadObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B) ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}
