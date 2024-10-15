package main.hw.hw15;

import java.util.List;

public class Student {

    private String name;
    private int group;
    private int course;
    private List<Integer> marks;

    public Student(String name, int group, int course, List<Integer> marks) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.marks = marks;
    }

    public static void removeStudentOrChangeCourse(List<Student> students) {
        for (Student student : students) {
            if (student.getAverageMark() < 3) {
                students.remove(student);
            } else {
                student.moveToNextCourse();
            }
        }
    }

    public static void printStudentsFromCourse(List<Student> students, int course) {
        System.out.println("Student on course " + course + ":");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static void printInfoStudent(List<Student> students) {
        System.out.println("Student: ");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public double getAverageMark() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.size();
    }

    public void moveToNextCourse() {
        course++;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group=" + group +
                ", course=" + course +
                ", marks=" + marks +
                '}';
    }
}