import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();

        sm.addStudent("Anna", 4.5);
        sm.addStudent("Stepan", 2.4);
        sm.addStudent("Sasha", 3.9);
        sm.addStudent("Ylia", 4.2);
        sm.addStudent("Semion", 4.1);
        sm.addStudent("Marya", 2.9);
        sm.addStudent("Natasha", 4.8);

        System.out.println(sm.findById(4));

        sm.sortByGrade();
        printStudentManager(sm.getAllStudents());

        sm.sortByName();
        printStudentManager(sm.getAllStudents());

        List<Student> topThreeStudents = sm.getTopStudents(3);
        printStudentManager(topThreeStudents);

        double averageRating = sm.getAverageGrade();
        System.out.println("Average Rating: " + averageRating);
        System.out.println("_______________________________________");

        List<Student> rangeFilterStudents = sm.getStudentsByGradeRange(3.2, 4.2);
        printStudentManager(rangeFilterStudents);

        sm.removeStudent(2);
        printStudentManager(sm.getAllStudents());

        List<Student> copySM = sm.getAllStudents();
        copySM.removeFirst();
        printStudentManager(sm.getAllStudents());
        printStudentManager(copySM);
    }

    private static void printStudentManager(List<Student> sm) {
        System.out.println("_______________________________________");
        for (Student student : sm) {
            System.out.println(student);
        }
        System.out.println("_______________________________________");
    }
}