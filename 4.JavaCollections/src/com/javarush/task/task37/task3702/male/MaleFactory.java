package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class MaleFactory implements AbstractFactory {
    @Override
    public Human getPerson(int age) {
        if (age < 20 && age > 12) {
            return new TeenBoy();
        }
        if (age < 13) {
            return new KidBoy();
        }
        return new Man();
    }
}
