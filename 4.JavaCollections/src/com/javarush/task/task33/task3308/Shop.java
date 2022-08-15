package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    public Goods goods = new Goods("S1", "S2");
    public int count = 12;
    public double profit = 123.4;
    public String[] secretData = {"String1", "String2", "String3", "String4", "String5"};

    public static class Goods {
        List<String> names = new ArrayList<>();

        public Goods(String...names) {
            this.names.addAll(Arrays.asList(names));
        }

        public Goods() {

        }
    }

    public String toString() {
        return "Shop{" +
                "goods=" + goods +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + (secretData == null ? null : Arrays.asList(secretData)) +
                '}';
    }
}
