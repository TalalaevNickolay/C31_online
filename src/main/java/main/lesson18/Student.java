package main.lesson18;

import java.util.List;

public class Student {
    private String name;
    private List<Integer> grades;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public Student(String name, List<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }
}
