import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Misha", "Vasiliev", "misha@example.com", 3.8);
        Student s2 = new Student("Masha", "Mironova", "masha@example.com", 4.3);
        Student s3 = new Student("Alex", "Sergeev", "Sergeev.A@example.com", 4.0);
        Student s4 = new Student("Liza", "Pushkareva", "PusL12@example.com", 3.5);
        Student s5 = new Student("Misha", "Vasiliev", "misha25@example.com", 4.5);

        try {
            Student s6 = new Student("Misha", "Vasiliev", "mi@@sha25@example.com", 4.5);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        Set<Student> students = new HashSet<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        System.out.println(students.contains(s2));
        System.out.println(students.contains(new Student("Masha", "Mironova", "masha@example.com", 4.3)));

        s3.setGrade(4.0);
        System.out.println(students.contains(s3));
    }
}