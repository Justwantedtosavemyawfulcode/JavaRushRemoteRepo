package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Contact, Customer {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }
        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String phoneNumber = String.valueOf(data.getPhoneNumber());
            if (phoneNumber.length() < 10) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = phoneNumber.length(); i < 10; i++) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(phoneNumber);
                phoneNumber = stringBuilder.toString();
            }
            String number1 = phoneNumber.substring(phoneNumber.length() - 7, phoneNumber.length() - 4);
            String number2 = phoneNumber.substring(phoneNumber.length() - 4, phoneNumber.length() - 2);
            String number3 = phoneNumber.substring(phoneNumber.length() - 2);
            String code = phoneNumber.substring(0, phoneNumber.length() - 7);

            return String.format("+%s(%03d)%s-%s-%s", data.getCountryPhoneCode(), Integer.parseInt(code), number1, number2, number3);
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}