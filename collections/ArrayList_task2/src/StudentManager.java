import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


/**
 * Класс для управления списком студентов.
 *
 * <p>Предоставляет методы для добавления, удаления, поиска, сортировки
 * и фильтрации студентов.</p>
 *
 * @author Решетников С.В.
 * @version 1.0
 */
public class StudentManager {

    private List<Student> students;

    /**
     * Конструктор по умолчанию.
     * Инициализирует пустой список студентов.
     */
    public StudentManager() {
        students = new ArrayList<>();
    }

    /***
     * Добавляет нового студента (id генерируется автоматически).
     * @param name String имя студента
     * @param grade double средний балл
     * @throws IllegalArgumentException если имя невалидно или оценка вне диапазона
     */
    public void addStudent(String name, double grade) {
        students.add(new Student(name, grade));
    }

    /***
     * Удаляет студента по id.
     * @param id int уникальный номер студента
     * @return boolean Возвращает true, если удаление успешно
     */
    public boolean removeStudent(int id) {
        return students.removeIf(n -> n.getId() == id);
    }

    /***
     * Возвращает студента по id.
     * @param id int уникальный номер студента.
     * @return Student Возвращает студента. Если студент не найден, возвращает null.
     */
    public Student findById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return students.get(i);
            }
        }

        return null;
    }

    /***
     * Возвращает список студентов с указанным именем.
     * @param name - имя студента.
     * @return - Возвращает список студентов с указанным именем в формате
     * List<Student></Student>
     */
    public List<Student> findByName(String name) {
        return students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    /***
     * Возвращает список из count студентов с самыми высокими оценками.
     * @param count - количество студентов, которое необходимо отсортировать.
     * @return - Возвращает список из count студентов с самыми высокими оценками.
     * Если count больше размера списка — вернуть всех.
     */
    public List<Student> getTopStudents(int count) {
        if (count >= students.size()) {
            return students.stream()
                    .sorted(Comparator.comparingDouble(Student::getGrade))
                    .collect(Collectors.toList());
        } else {
            return students.stream()
                    .sorted(Comparator.comparingDouble(Student::getGrade).reversed())
                    .limit(count)
                    .collect(Collectors.toList());
        }
    }

    /***
     * @return - Возвращает среднюю оценку всех студентов
     */
    public double getAverageGrade() {
        if (students.isEmpty()) {
            return 0.0;
        }
        double result = 0;
        for (int i = 0; i < students.size(); i++) {
            result += students.get(i).getGrade();
        }
        return Math.round(((result / students.size()) * 100.00) / 100.00);
    }

    /***
     * Сортирует студентов по оценке от высшей к низшей.
     * Изменяет исходный список.
     */
    public void sortByGrade() {
        students.sort(Comparator.comparingDouble(Student::getGrade).reversed());
    }

    /***
     * Сортирует студентов по имени. Изменяет исходный список.
     */
    public void sortByName() {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }

    /***
     * Возвращает список студентов, чьи оценки в диапазоне [min, max]
     * @param min - минимальная оценка диапазона (включительно)
     * @param max - максимальная оценка диапазона (включительно)
     * @return Возвращает список студентов, чьи оценки в диапазоне [min, max]
     */
    public List<Student> getStudentsByGradeRange(double min, double max) {
        if (min > max) {
            throw new IllegalArgumentException("min не может быть больше max");
        }
        return students.stream()
                .filter(s -> s.getGrade() >= min)
                .filter(s -> s.getGrade() <= max)
                .collect(Collectors.toList());
    }

    /***
     * Возвращает копию списка студентов.
     * @return List<Student></Student>
     */
    public List<Student> getAllStudents() {
        return students.stream()
                .map(s -> new Student(s.getName(), s.getGrade()))
                .collect(Collectors.toList());
    }

    /***
     * Удаляет всех студентов
     */
    public void clear() {
        students.clear();
    }

    /***
     * Возвращает количество студентов
     * @return int
     */
    public int size() {
        return students.size();
    }
}
