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
            return defineClass(null, bytes, 0, bytes.length);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
