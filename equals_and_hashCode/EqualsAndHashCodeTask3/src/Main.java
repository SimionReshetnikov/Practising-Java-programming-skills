import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("4510", "123456",
                "Иванов Иван", LocalDate.of(1973, 3, 15));

        Person p2 = new Person("4510", "234567",
                "Петрова Мария", LocalDate.of(1987, 4, 25));

        Person p3 = new Person("4513", "567890",
                "Кузнецов Дмитрий", LocalDate.of(1992, 2, 18));

        Person p4 = new Person("4514", "678901",
                "Попова Елена", LocalDate.of(1988, 9, 27));

        Person p5 = new Person("4510", "123456",
                "Иванов Иван", LocalDate.of(1973, 3, 15));

        Person p6 = new Person("4516", "890123",
                "Морозова Ольга", LocalDate.of(1983, 7, 30));

        Person p7 = new Person("4517", "901234",
                "Новиков Алексей", LocalDate.of(1991, 5, 9));

        Person p8 = new Person("4517", "901234",
                "Новиков Алексей", LocalDate.of(1991, 5, 9));

        List<Person> people = new ArrayList<>(List.of(p1, p2, p3, p4, p5, p6, p7, p8));

        List<Person> duplicate = DuplicateDetector.findDuplicates(people);
        printList(duplicate);

        System.out.println(DuplicateDetector.getUniqueCount(people));

        List<Person> uniqueList = DuplicateDetector.removeDuplicates(people);
        System.out.println(uniqueList);

        Map<Person, Integer> map = DuplicateDetector.getFrequencyMap(people);
        printMap(map);
    }

    private static void printList(List<Person> list) {
        System.out.println("_____________________________________");

        for (Person element : list) {
            System.out.println(element.toString());
        }

        System.out.println("_____________________________________");
    }

    private static void printMap(Map<Person, Integer> map) {
        System.out.println("_____________________________________");

        map.forEach((key, value) -> System.out.println(key + " : " + value));

        System.out.println("_____________________________________");
    }
}