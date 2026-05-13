import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        String[] arrayWords = ("и обычный ключ дверной много разных есть ключей родник дверной среди среди среди много разных " +
                "есть ключей ключ родник среди камней ключ скрипичный завитой").split("\\s++");
        List<String> words = new ArrayList<>(List.of(arrayWords));

        printResult(words);
        printResult(TaskOne.getListOfUniqueWords(words));
        printResult(TaskOne.getListWordsLengthMoreThree(words));
        printResult(TaskOne.getSortedWords(words));
        printResult(TaskOne.getLongestWord(words));

        Map<String, Long> resultTaskOne = TaskOne.getMapCountingWords(words);

        for (Map.Entry<String, Long> entry : resultTaskOne.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("-----------------------------------------------");

    }

    private static void printResult(Collection<?> collection) {
        collection.forEach(System.out::println);
        System.out.println("-----------------------------------------------");
    }
}
