import java.util.ArrayList;
import java.util.List;

public class TestClass {

    private List<Integer> numbersList;

    public TestClass(int capacitySize) {
        if (capacitySize <= 0) {
            capacitySize = 1;
        }
        numbersList = new ArrayList<>(capacitySize);
    }

    public void add(int... numbers) {
        for (int number : numbers) {
            numbersList.add(number);
        }
    }

    @Deprecated
    public int sumAllNumbers() {
        int result = 0;
        for (int number : numbersList) {
            result += number;
        }
        return result;
    }

    @Important(level = 3)
    public int sumAllNumbersNow() {
        return numbersList.stream()
                .reduce(0, Integer::sum);
    }

    @Deprecated
    public List<Integer> evenElements() {
        List<Integer> result = new ArrayList<>();
        for (int number : numbersList) {
            if (number % 2 == 0) {
                result.add(number);
            }
        }
        return result;
    }

    @Important
    public List<Integer> evenElementsStream() {
        return numbersList.stream()
                .filter(n -> n % 2 == 0)
                .toList();
    }

}
