package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        pathToAnimals = pathToAnimals.substring(1);
        Path pathToDirectory = Paths.get(pathToAnimals);
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(pathToDirectory);
        for (Path path : directoryStream) {
            ClassLoader customClassLoader = new CustomClassLoader();
            Class<?> clazz = customClassLoader.loadClass(path.toString());
            try {
                Animal animal = (Animal) clazz.newInstance();
                resultSet.add(animal);
                System.out.println();
            }
            catch (ClassCastException | IllegalAccessException e) {

            }
        }
        return resultSet;
    }
}
