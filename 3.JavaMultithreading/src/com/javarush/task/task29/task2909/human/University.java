package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int age;
    private String name;
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student st : students) {
            if (st.getAverageGrade() == averageGrade) return st;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student st = students.get(0);
        for (Student stt : students) {
            if (stt.getAverageGrade() > st.getAverageGrade()) st = stt;
        }
        return st;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student st = students.get(0);
        for (Student stt : students) {
            if (stt.getAverageGrade() < st.getAverageGrade()) st = stt;
        }
        return st;
    }
    public void expel(Student student) {
        //TODO:
        students.remove(students.indexOf(student));
    }
}