/**
 * Класс, представляющий студента с уникальным идентификатором, именем и средней оценкой.
 *
 * <p>Студенты считаются одинаковыми по {@code id} (сравнение через equals/hashCode).</p>
 *
 * @author Решетников С.В.
 * @version 1.0
 */
public class Student {

    private int id;
    private static int count = 0;
    private String name;
    private double grade;

    /**
     * Конструктор для создания нового студента.
     *
     * <p>ID генерируется автоматически на основе статического счетчика.</p>
     *
     * @param name  имя студента (не может быть null или пустым)
     * @param grade средняя оценка (должна быть в диапазоне от 2.0 до 5.0)
     * @throws IllegalArgumentException если имя невалидно или оценка вне допустимого диапазона
     */
    public Student(String name, double grade) {
        nameCheck(name);
        gradeCheck(grade);
        count++;
        id = count;
        this.name = name;
        this.grade = grade;
    }

    /**
     * Возвращает уникальный идентификатор студента.
     *
     * @return ID студента (начинается с 1)
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает имя студента.
     *
     * @return имя студента
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает среднюю оценку студента.
     *
     * @return средняя оценка (от 2.0 до 5.0)
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Устанавливает новую среднюю оценку студента.
     *
     * @param newGrade новая оценка (от 2.0 до 5.0)
     * @throws IllegalArgumentException если оценка вне допустимого диапазона
     */
    public void setGrade(double newGrade) {
        gradeCheck(newGrade);
        grade = newGrade;
    }

    /**
     * Возвращает строковое представление студента.
     *
     * @return строка в формате "1: Имя - Иван, Средний балл - 4.5"
     */
    @Override
    public String toString() {
        return String.format("%d: Имя - %s, Средний балл - %.1f", id, name, grade);
    }

    /**
     * Сравнивает двух студентов по ID.
     *
     * <p>Два студента считаются равными, если у них одинаковый ID.</p>
     *
     * @param o объект для сравнения
     * @return true если студенты имеют одинаковый ID, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Student student = (Student) o;
        return id == student.getId();
    }

    /**
     * Возвращает хэш-код студента на основе ID.
     * <p>Хэш-код согласован с equals(): одинаковые ID → одинаковый хэш.</p>
     * @return хэш-код (равен значению ID)
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * Проверяет корректность имени.
     *
     * @param name имя для проверки
     * @throws IllegalArgumentException если имя null, пустое или состоит из пробелов
     */
    private void nameCheck(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Поле \"Имя\" не может быть пустым");
        }
    }

    /**
     * Проверяет корректность средней оценки.
     *
     * @param grade оценка для проверки
     * @throws IllegalArgumentException если оценка меньше 2.0 или больше 5.0
     */
    private void gradeCheck(double grade) {
        if (grade < 2.0 || grade > 5.0) {
            throw new IllegalArgumentException("Поле \"Средний балл\" не может быть меньше 2 и больше 5");
        }
    }
}
