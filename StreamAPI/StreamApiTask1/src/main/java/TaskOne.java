import java.util.*;
import java.util.stream.Collectors;

public class TaskOne {

    private TaskOne() {}

    public static List<String> getListOfUniqueWords(List<String> words) {
        return words.stream().map(s -> s.toLowerCase().trim())
                .distinct().toList();
    }

    public static Map<String, Long> getMapCountingWords(List<String> words) {
        return words.stream().map(s -> s.toLowerCase().trim())
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    public static List<String> getLongestWord(List<String> words) {
        int maxLength = words.stream().mapToInt(s -> s.length())
                .max().orElse(0);

        return words.stream().filter(w -> w.length() == maxLength)
                .distinct().toList();
    }

    public static List<String> getSortedWords(List<String> words) {
        return words.stream().sorted().toList();
    }

    public static List<String> getListWordsLengthMoreThree(List<String> words) {
        return words.stream().filter(s -> s.length() > 3).toList();
    }
}
