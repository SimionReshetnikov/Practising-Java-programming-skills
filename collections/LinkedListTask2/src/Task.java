/**
 * Класс, представляющий задачу в списке дел.
 * <p>
 * Каждая задача имеет уникальный идентификатор, название и приоритет.
 * ID генерируется автоматически при создании задачи.
 * </p>
 */
public class Task {
    private int id;
    private String title;
    private int priority;

    //Статический счетчик
    private static int count = 0;

    /***
     * Конструктор класса Task.
     * @param title - Описание задачи в формате String
     * @param priority - Уровень приоритета задачи с 1 до 5
     * @throws IllegalArgumentException - выводится при неверном формате параметров
     * title и priority
     */
    public Task(String title, int priority) {
        titleValidation(title);
        priorityValidation(priority);
        this.title = title;
        this.priority = priority;
        count++;
        id = count;
    }

    public int getId() {
        return id;
    }
    public int getPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }

    /***
     * Метод для вывода информации о задаче.
     * @return информация о задаче в формате String
     */
    @Override
    public String toString() {
        return String.format("Задача: id - %d, title - %s, priority - %d",
                id, title, priority);
    }

    /***
     * Метод проверяет входное значение. Если значение равно null или передается пустая строка,
     * то генерируется исключение.
     * @param title входной параметр типа String
     * @throws IllegalArgumentException генерируется, если входной параметр
     * null или пустой.
     */
    private void titleValidation(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Значение параметра title не может быть пустым");
        }
    }

    /***
     * Метод проверяет входное значение. Если значение не в диапазоне [1, 5], то
     * генерируется исключение.
     * @param priority входной параметр типа int
     * @throws IllegalArgumentException если входной параметр не лежит в диапазоне [1, 5]
     */
    private void priorityValidation(int priority) {
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Значение параметра priority лежит в диапазоне от " +
                    "1 до 5 включительно");
        }
    }
}
