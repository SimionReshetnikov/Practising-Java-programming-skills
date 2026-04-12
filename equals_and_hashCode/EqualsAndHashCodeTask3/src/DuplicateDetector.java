import java.util.*;

/**
 * Утилитарный класс для обнаружения и обработки дубликатов в коллекциях.
 * <p>
 * Содержит набор статических методов для работы со списками:
 * поиск дубликатов, подсчет уникальных элементов, удаление повторений
 * и построение карты частоты встречаемости.
 * </p>
 * <p>
 * Все методы используют хеш-таблицы (HashSet/HashMap) для достижения
 * оптимальной производительности O(n) в среднем.
 * </p>
 */
public class DuplicateDetector {
    /**
     * Приватный конструктор для предотвращения создания экземпляров.
     * <p>
     * Класс является утилитарным и содержит только статические методы.
     * </p>
     */
    private DuplicateDetector() {}

    /**
     * Находит все дублирующиеся элементы в списке.
     * <p>
     * Алгоритм работы:
     * <ol>
     *   <li>Создается множество seen для отслеживания уже встреченных элементов</li>
     *   <li>Создается множество result для хранения дубликатов</li>
     *   <li>При первом появлении элемент добавляется в seen</li>
     *   <li>При повторном появлении элемент добавляется в result</li>
     * </ol>
     * </p>
     *
     * @param <T> тип элементов в списке
     * @param list входной список (не может быть null)
     * @return список уникальных дублирующихся элементов (порядок не гарантируется)
     * @throws IllegalArgumentException если list == null
     */
    public static <T> List<T> findDuplicates(List<T> list) {
        listValidation(list);
        Set<T> result = new HashSet<>();
        Set<T> seen = new HashSet<>();

        for (T item : list) {
            if (!seen.add(item)) {
                result.add(item);
            }
        }

        return new ArrayList<>(result);
    }

    /**
     * Подсчитывает количество уникальных элементов в списке.
     * <p>
     * Метод использует HashSet для автоматического удаления дубликатов,
     * после чего возвращает размер полученного множества.
     * </p>
     *
     * @param <T> тип элементов в списке
     * @param list входной список (не может быть null)
     * @return количество уникальных элементов
     * @throws IllegalArgumentException если list == null
     */
    public static <T> int getUniqueCount(List<T> list) {
        listValidation(list);
        Set<T> uniqueSets = new HashSet<>(list);
        return uniqueSets.size();
    }

    /**
     * Удаляет все дубликаты из списка, сохраняя порядок первого вхождения.
     * <p>
     * Алгоритм сохраняет порядок элементов: каждый элемент добавляется
     * в результирующий список только при первом появлении.
     * </p>
     *
     * @param <T> тип элементов в списке
     * @param list входной список (не может быть null)
     * @return новый список без дубликатов (порядок сохранен)
     * @throws IllegalArgumentException если list == null
     */
    public static <T> List<T> removeDuplicates(List<T> list) {
        listValidation(list);
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();

        for (T item : list) {
            if (seen.add(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Создает карту частоты встречаемости элементов в списке.
     * <p>
     * Каждому элементу списка ставится в соответствие количество его
     * вхождений в исходный список.
     * </p>
     *
     * @param <T> тип элементов в списке
     * @param list входной список (не может быть null)
     * @return HashMap, где ключ - элемент, значение - количество его вхождений
     * @throws IllegalArgumentException если list == null
     */
    public static <T> Map<T, Integer> getFrequencyMap(List<T> list) {
        listValidation(list);
        Map<T, Integer> res = new HashMap<>();
        for (T item : list) {
            res.put(item, res.getOrDefault(item, 0) + 1);
        }
        return res;
    }

    private static<T> void listValidation(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Передаваемое значение не может быть null");
        }
    }
}
