package com.javarush.task.task30.task3001;

import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Конвертер систем счислений
*/

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef

        number = new Number(NumberSystemType._10, "0");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);

        number = new Number(NumberSystemType._12, "B");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        BigInteger initialNumber = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
        //напишите тут ваш код
        return new Number(expectedNumberSystem, initialNumber.toString(expectedNumberSystem.getNumberSystemIntValue()));
    }
}
