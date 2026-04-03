import java.util.*;

public class ArrayListTasks {

    private ArrayListTasks() {}

    /**
     * Удаляет все четные числа из списка и возвращает их количество.
     *
     * @param list список целых чисел (не должен быть null или пустым)
     * @return количество удаленных четных элементов
     * @throws IllegalArgumentException если переданный список null или пуст
     */
    public static int removeEvenNumbers(List<Integer> list) {
        listValidation(list);
        int result = 0;
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                result++;
                iterator.remove();
            }
        }

        return result;
    }

    /**
     * Разворачивает порядок элементов в списке в обратную сторону.
     * Метод изменяет исходный список, не создавая новый.
     *
     * @param list список строк для разворота (не должен быть null или пустым)
     * @throws IllegalArgumentException если переданный список null или пуст
     */
    public static void reverseList(List<String> list) {
        listValidation(list);
        String tmpVariable;
        int middleList = list.size() / 2;
        int count = 0;

        for (int i = list.size() - 1; i >= middleList; i--) {
            tmpVariable = list.get(i);
            list.set(i, list.get(count));
            list.set(count, tmpVariable);
            count++;
        }
    }

    /**
     * Находит общие элементы, присутствующие в обоих списках.
     * Результат не содержит дубликатов.
     *
     * @param list1 первый список чисел (не должен быть null или пустым)
     * @param list2 второй список чисел (не должен быть null или пустым)
     * @return ArrayList с уникальными общими элементами
     * @throws IllegalArgumentException если любой из переданных списков null или пуст
     */
    public static ArrayList<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
        listValidation(list1, list2);

        List<Integer> smaller = list1.size() <= list2.size() ? list1 : list2;
        List<Integer> larger = list1.size() <= list2.size() ? list2 : list1;

        Set<Integer> set = new HashSet<>(smaller);
        Set<Integer> resultSet = new HashSet<>();

        for (Integer num : larger) {
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }

        return new ArrayList<>(resultSet);
    }

    /**
     * Преобразует все строки в списке в верхний регистр.
     * Исходный список остается неизменным.
     *
     * @param list список строк для преобразования (не должен быть null или пустым)
     * @return новый список со строками в верхнем регистре
     * @throws IllegalArgumentException если переданный список null или пуст
     */
    public static List<String> toUpperCaseList(List<String> list) {
        listValidation(list);

        List<String> result = new ArrayList<>();

        for (String word : list) {
            result.add(word.toUpperCase());
        }

        return result;
    }

    /**
     * Проверяет, что переданные списки не являются null и не пусты.
     *
     * @param lists массив списков для проверки
     * @throws IllegalArgumentException если любой из списков null или пуст
     */
    @SafeVarargs
    private static <T> void listValidation(List<T>... lists) {
        for (List<T> list : lists) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Передаваемый список не может быть пустым");
            }
        }
    }
}
