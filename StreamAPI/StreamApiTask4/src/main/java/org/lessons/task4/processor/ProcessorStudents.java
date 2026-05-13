package org.lessons.task4.processor;

import org.lessons.task4.students.Faculty;
import org.lessons.task4.students.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcessorStudents {

    private ProcessorStudents() {}

    /***
     * Метод фильтрует список студентов по среднему баллу. Балл должен быть больше 4,0.
     * @param students List<Student> список студентов </Student>
     * @return List<Student>отфильтрованный список студентов</Student>
     */
    public static List<Student> getListStudentsGradeMoreFour(List<Student> students) {

        return students.stream().filter(s -> (s.getGrade() - 4.0) > 0.0001)
                .toList();
    }

    /***
     * Метод группирует студентов по факультетам.
     * @param students List<Student> список студентов </Student>
     * @return Map<Faculty факультет студента, List<Student> список студентов данного факультета </Student>>
     */
    public static Map<Faculty, List<Student>> getMapStudentsFaculty(List<Student> students) {

        return students.stream().collect(Collectors.groupingBy(s -> s.getFaculty()));
    }

    /***
     * Метод группирует студентов по факультетам и показывает среднее значение оценки студентов.
     * @param students List<Student> список студентов </Student>
     * @return Map<Faculty факультет студента, Double средняя оценка студентов факультета>
     */
    public static Map<Faculty, Double> calculateAverageMarkForFaculty(List<Student> students) {

        return students.stream().collect(Collectors.groupingBy(s -> s.getFaculty(),
                Collectors.averagingDouble(s -> s.getGrade())));
    }

    /***
     * Метод ищет студента с максимальной оценкой по всему университету.
     * @param students List<String> список студентов </String>.
     * @return Student студент с наивысшей оценкой.
     * @throws IllegalArgumentException в случае отсутствия студента с наивысшей оценкой (передан пустой List).
     */
    public static Student getStudentWithMaxAverage(List<Student> students) {

        return students.stream().max(Comparator.comparing(Student::getGrade))
                .orElseThrow(IllegalArgumentException::new);
    }
}
