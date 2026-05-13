import java.util.List;
import java.util.OptionalInt;

public class ConverterInteger {

    private ConverterInteger() {}

    /***
     * @param numbers список Integer.
     * @return (int) сумма положительных чисел.
     */
    public static int sumAllPositiveNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n > 0)
                .mapToInt(n -> n).sum();
    }

    /***
     * @param numbers список чисел Integer.
     * @return (long) Количество отрицательных чисел в numbers.
     */
    public static long countNegativeNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n < 0).count();
    }

    /***
     * @param numbers список чисел Integer.
     * @return (int) максимальное положительное число.
     */
    public static int getMaxPositiveNumber(List<Integer> numbers) {
        OptionalInt result = numbers.stream().filter(n -> n > 0)
                .mapToInt(n -> n).max();

        return result.isPresent() ? result.getAsInt() : 0;
    }

    /***
     * @param numbers список чисел Integer.
     * @return (List<Integer>) Список квадратов всех чисел из numbers
     */
    public static List<Integer> getListSquareNumbers(List<Integer> numbers) {
        return numbers.stream().map(n -> n * n)
                .toList();
    }

    /***
     * @param numbers список чисел Integer.
     * @return (List<Integer>) Список чисел, которые делятся без остатка на 3 из numbers
     */
    public static List<Integer> getListNumbersDivideThree(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 3 == 0)
                .toList();
    }
}
