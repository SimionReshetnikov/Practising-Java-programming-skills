import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для управления списком задач.
 * <p>
 * Задачи хранятся в {@link LinkedList} и могут быть отсортированы по приоритету.
 * </p>
 */
public class TodoList {
    private LinkedList<Task> tasks;

    /***
     * Конструктор для создания списка задач
     */
    public TodoList() {
        tasks = new LinkedList<>();
    }

    /***
     * Метод для добавления задачи в список.
     * При добавлении задача сортируется по приоритету.
     * @param title Описание задачи
     * @param priority приоритет задачи. Указывается в пределах [1, 5]
     */
    public void addTask(String title, int priority) {
        tasks.add(new Task(title, priority));
        sortTasksInPriorityAndId();
    }

    /***
     * Добавление задачи в конец списка без учета приоритета
     * @param title Описание задачи
     * @param priority приоритет задачи. Указывается в пределах [1, 5]
     */
    public void addToEnd(String title, int priority) {
        tasks.addLast(new Task(title, priority));
    }

    /***
     * Добавление задачи в начало списка без учета приоритета
     * @param title Описание задачи
     * @param priority приоритет задачи. Указывается в пределах [1, 5]
     */
    public void addToStart(String title, int priority) {
        tasks.addFirst(new Task(title, priority));
    }

    /***
     * Удаляет задачу из списка по id.
     * @param id уникальный номер задачи в формате int
     * @return Возвращает true в случае успешного удаления задачи,
     * в противном случае возвращает false
     */
    public boolean removeTask(int id) {
        Iterator<Task> iterator = tasks.iterator();
        while(iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    /***
     * Удаляет первую задачу из списка
     * @return Возвращает удаленную задачу в случае успешного удаления,
     * в ином случае возвращает null.
     */
    public Task completeFirst() {
        if (tasks.isEmpty()) {
            return null;
        }

        return tasks.removeFirst();
    }

    /***
     * Возвращает список задач с заданным приоритетом.
     * @param priority приоритет задачи. Указывается в пределах [1, 5]
     * @return список задач в формате List.
     * @throws IllegalArgumentException передан несоответствующий параметр приоритета, вернется null.
     */
    public List<Task> getTasksByPriority(int priority) {
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Приоритет должен быть от 1 до 5");
        }
        return tasks.stream()
                .filter(t -> t.getPriority() == priority)
                .collect(Collectors.toList());
    }

    /***
     * Перемещает задачу с указанным id в конец списка
     * @param id уникальный номер задачи в формате int
     * @return возвращает true, если задача найдена и перемещена, если нет, то возвращает false
     */
    public boolean moveToEnd(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                tasks.addLast(task);
                return true;
            }
        }
        return false;
    }

    /***
     * Формирует строку для вывода информации о задачах в консоль
     * @return возвращает информацию о всех задачах в списке в формате String
     */
    public String getAllTasksString() {
        StringBuilder sb = new StringBuilder();
        for (Task element : tasks) {
            sb.append(element.toString()).append("\n");
        }
        return sb.toString();
    }

    /***
     * Возвращает количество задач
     * @return значение в формате int
     */
    public int size() {
        return tasks.size();
    }

    /***
     * Проверка пуст ли список
     * @return Если список пуст, возвращается true.
     * Если нет, то false
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /***
     * Удаление всех задач из списка
     */
    public void clear() {
        tasks.clear();
    }

    /***
     * Метод для сортировки сначала по приоритету,
     * затем если приоритеты одинаковые, то по id
     */
    private void sortTasksInPriorityAndId() {
        tasks.sort(Comparator.comparing(Task::getPriority)
                .thenComparing(Task::getId));
    }
}
