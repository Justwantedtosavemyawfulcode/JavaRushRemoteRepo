package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("C://Users/leonid/Desktop/1.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
//            User newUser = new User();
//            newUser.setFirstName("John");
//            newUser.setLastName("Doe");
//            newUser.setBirthDate(new Date());
//            newUser.setMale(true);
//            newUser.setCountry(User.Country.UKRAINE);
//            javaRush.users.add(newUser);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            if (users.size() > 0) {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
                for (User user : users) {
                    writer.write(user.getFirstName() + "splitter");
                    writer.write(user.getLastName() + "splitter");
                    writer.write(user.getBirthDate().getTime() + "splitter");
//                System.out.println(user.getBirthDate());
                    writer.write(user.isMale() + "splitter");
                    writer.write(user.getCountry() + "splitter");
                }
                writer.flush();
            }
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String l = reader.readLine();
            if (l != null) {
                String[] line = l.split("splitter");
                for (int i = 0; i < line.length; i += 5) {
                    User tmpUser = new User();
                    tmpUser.setFirstName(line[i]);
                    tmpUser.setLastName(line[i + 1]);
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss.SSS z yyyy");
//                Date date = simpleDateFormat.parse(line[i+2]);
                    Date date = new Date(Long.parseLong(line[i + 2]));
//                System.out.println(date);
                    tmpUser.setBirthDate(date);
                    tmpUser.setMale(Boolean.parseBoolean(line[i + 3]));
                    switch (line[i + 4]) {
                        case "UKRAINE":
                            tmpUser.setCountry(User.Country.UKRAINE);
                            break;
                        case "RUSSIA":
                            tmpUser.setCountry(User.Country.RUSSIA);
                            break;
                        case "OTHER":
                            tmpUser.setCountry(User.Country.OTHER);
                            break;
                    }
                    this.users.add(tmpUser);
                }
            }
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
