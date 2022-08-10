package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        T returnedClass = objectMapper.readValue(fileReader, clazz);
        return returnedClass;
    }

    public static void main(String[] args) {

    }
}
