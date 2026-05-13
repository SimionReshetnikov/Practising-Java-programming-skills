package org.lessons.task4.students;

public class Student {

    private String name;
    private double grade;
    private Faculty faculty;

    public Student(String name, double grade, Faculty faculty) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя студента не может быть null или пустой строкой.");
        }

        if (grade < 2.0) {
            this.grade = 2.0;
        } else {
            this.grade = Math.min(grade, 5.0);
        }

        this.name = name;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Grade: " +
                grade + " Faculty: " + faculty.getNameFaculty();
    }
}
