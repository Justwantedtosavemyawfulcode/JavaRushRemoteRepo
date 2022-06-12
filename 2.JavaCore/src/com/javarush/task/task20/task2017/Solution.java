package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException {
        try {
            return (A) objectStream.readObject();
        }
        catch (Exception e) {
            return null;
        }
    }

    public class A implements Serializable {
        private static final long serialVersionUID = -1531549789821273680L;
    }

    public class B extends A {
        private static final long serialVersionUID = 1453956089556702821L;

        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
