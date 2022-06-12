package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();


    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student foundedStudent = null;
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                foundedStudent = student;
            }
        }
        //TODO:
        return foundedStudent;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student foundedStudent = null;
        double maxGrade = 0;
        for (Student student : students) {
            if (student.getAverageGrade() > maxGrade) {
                foundedStudent = student;
                maxGrade = student.getAverageGrade();
            }
        }
        //TODO:
        return foundedStudent;
    }

//    public void getStudentWithMinAverageGradeAndExpel() {
//        expel(getStudentWithMinAverageGrade());
//        //TODO:
//    }

    public Student getStudentWithMinAverageGrade() {
        Student foundedStudent = null;
        double minGrade = students.get(0).getAverageGrade();
        for (Student student : students) {
            if (student.getAverageGrade() < minGrade) {
                foundedStudent = student;
                minGrade = student.getAverageGrade();
            }
        }
        //TODO:
        return foundedStudent;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}