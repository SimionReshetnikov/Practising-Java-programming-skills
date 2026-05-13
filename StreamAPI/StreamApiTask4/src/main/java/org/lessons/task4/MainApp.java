package org.lessons.task4;

import org.lessons.task4.processor.ProcessorStudents;
import org.lessons.task4.students.Faculty;
import org.lessons.task4.students.Student;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Ivan", 3.5, Faculty.GIG),
                new Student("Semion", 4.5, Faculty.IEF),
                new Student("Irina", 4.8, Faculty.GMF),
                new Student("Alexandr", 4.1, Faculty.IEF),
                new Student("Danila", 3.8, Faculty.IEF),
                new Student("Maria", 2.8, Faculty.ZO),
                new Student("Natasha", 3.2, Faculty.GTF),
                new Student("Lera", 4.0, Faculty.GTF),
                new Student("Yuri", 4.1, Faculty.ZO),
                new Student("Constantin", 4.3, Faculty.ZO),
                new Student("Bysia", 5.0, Faculty.IEF)
        ));

        printCollection(ProcessorStudents.getListStudentsGradeMoreFour(students));
        printMap(ProcessorStudents.getMapStudentsFaculty(students));
        printMap(ProcessorStudents.calculateAverageMarkForFaculty(students));
        System.out.println(ProcessorStudents.getStudentWithMaxAverage(students));
    }

    private static void printCollection(Collection<?> collection) {

        collection.forEach(System.out::println);
        System.out.println("____________________________________________");
    }

    private static <K, V> void printMap(Map<K, V> map) {

        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("_______________________________________________");
    }
}
