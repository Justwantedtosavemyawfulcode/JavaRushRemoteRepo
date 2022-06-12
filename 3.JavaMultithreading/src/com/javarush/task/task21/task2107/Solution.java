package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public Object clone() {
        Solution clonedSolution = new Solution();
        Map<String, User> clonedUsers = new LinkedHashMap();
        for (Map.Entry<String, User> entry:users.entrySet()) {
            clonedUsers.put(entry.getKey(), entry.getValue());
        }
        clonedSolution.users = clonedUsers;
        return clonedSolution;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        clone = (Solution) solution.clone();
        System.out.println(solution);
        System.out.println(clone);

        System.out.println(solution.users);
        System.out.println(clone.users);

    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public Object clone() {
            return new User(this.age, this. name);
        }
    }
}
