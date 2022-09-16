package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Set<Animal> resultSet = new HashSet<>();
//        pathToAnimals = pathToAnimals.substring(1);
        File file = new File(pathToAnimals);
        Path pathToDirectory = file.toPath();
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(pathToDirectory);
        for (Path path : directoryStream) {
            ClassLoader customClassLoader = new CustomClassLoader();
            Class<?> clazz = customClassLoader.loadClass(path.toAbsolutePath().toString());
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                if (constructor.getParameterCount() == 0) {
                    resultSet.add((Animal) clazz.newInstance());
                }
            }
        }
        return resultSet;
    }
}
