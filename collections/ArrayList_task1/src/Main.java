import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int res = ArrayListTasks.removeEvenNumbers(numberList);
        System.out.println(res);

        printList(numberList);

        List<String> words1 = new ArrayList<>(List.of("apple", "banana", "strawberry", "rock", "potato"));
        List<String> words2 = new ArrayList<>(List.of("mango", "spun", "fork", "table", "word", "letter"));
        ArrayListTasks.reverseList(words1);
        ArrayListTasks.reverseList(words2);

        printList(words1);
        printList(words2);

        List<Integer> numberList2 = new ArrayList<>(List.of(1, 2, 4, 5, 4));
        List<Integer> numberList3 = new ArrayList<>(List.of(1, 3, 4, 5, 6, 4));
        ArrayList<Integer> result = ArrayListTasks.findCommonElements(numberList2, numberList3);

        printList(result);

        printList(ArrayListTasks.toUpperCaseList(words1));
    }

    public static <T> void printList(List<T> list) {
        System.out.println("---------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("---------------------------------------------");
    }
}
