package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(name));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String className = name.substring(name.lastIndexOf("\\") + 1, name.lastIndexOf(".")).trim();
        return defineClass(null, bytes, 0, bytes.length);
    }
}
