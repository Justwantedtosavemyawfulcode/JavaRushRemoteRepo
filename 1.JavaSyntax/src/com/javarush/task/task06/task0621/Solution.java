package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String dedName = bufferedReader.readLine();
        Cat catDedVasya = new Cat(dedName);

        String babushkaName = bufferedReader.readLine();
        Cat catBabaMurka = new Cat(babushkaName);

        String papaName = bufferedReader.readLine();
        Cat catPapaKotofey = new Cat(papaName, null, catDedVasya);

        String mamaName = bufferedReader.readLine();
        Cat catMamaVasylisa = new Cat(mamaName, catBabaMurka, null);

        String sonName = bufferedReader.readLine();
        Cat catSonMur4ik = new Cat(sonName, catMamaVasylisa, catPapaKotofey);

        String do4Name = bufferedReader.readLine();
        Cat catDo4Pushinka = new Cat(do4Name, catMamaVasylisa, catPapaKotofey);


        System.out.println(catDedVasya);
        System.out.println(catBabaMurka);
        System.out.println(catPapaKotofey);
        System.out.println(catMamaVasylisa);
        System.out.println(catSonMur4ik);
        System.out.println(catDo4Pushinka);
    }

    public static class Cat {
        private String name;
        private Cat father;
        private Cat mother;

        Cat(String name) {
            this.name = name;
        }

        public Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }


        @Override
        public String toString() {
            if (mother == null && father != null)
                return "The cat's name is " + name + ", no mother, father is " + father.name;
            if ((mother != null && father == null))
                return "The cat's name is " + name + ", mother is " + mother.name + ", no father";
            if (mother == null && father == null)
                return "The cat's name is " + name + ", no mother, no father";
            else
                return "The cat's name is " + name + ", mother is " + mother.name + ", father is " + father.name;
        }
    }

}
