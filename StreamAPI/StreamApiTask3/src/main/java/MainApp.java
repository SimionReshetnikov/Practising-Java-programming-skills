import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, -1, -2, -3, 5, -7, -10, 15, -20, 8, 5));
        printCollection(ConverterInteger.getListNumbersDivideThree(numbers));
        printCollection(ConverterInteger.getListSquareNumbers(numbers));
        System.out.println(ConverterInteger.countNegativeNumbers(numbers));
        System.out.println(ConverterInteger.getMaxPositiveNumber(numbers));
        System.out.println(ConverterInteger.sumAllPositiveNumbers(numbers));
    }

    public static void printCollection(Collection<? extends Number> collections) {
        collections.forEach(System.out::println);
        System.out.println("_________________________________");
    }
}
