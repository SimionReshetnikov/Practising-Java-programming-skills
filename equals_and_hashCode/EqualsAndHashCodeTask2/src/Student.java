import java.util.regex.Pattern;

/**
 * Класс, представляющий студента учебного заведения.
 *
 * <p>Содержит информацию о студенте: уникальный идентификатор, имя, фамилию,
 * email и среднюю оценку. Студенты считаются уникальными по идентификатору.</p>
 */

public class Student {

    /** Уникальный идентификатор студента */
    private final int id;
    /** Счетчик для генерации уникальных идентификаторов */
    private static int count;
    /** Паттерн для валидации email */
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    /** Имя студента */
    private final String firstName;
    /** Фамилия студента */
    private final String lastName;
    /** Email студента */
    private final String email;
    /** Средняя оценка студента (от 2.0 до 5.0) */
    private double grade;

    /**
     * Конструктор для создания нового студента.
     *
     * <p>ID генерируется автоматически на основе статического счетчика.</p>
     *
     * @param firstName имя студента (не может быть null или пустым)
     * @param lastName фамилия студента (не может быть null или пустым)
     * @param email email студента (должен соответствовать формату)
     * @param grade средняя оценка (от 2.0 до 5.0)
     * @throws IllegalArgumentException если любой из параметров не прошел валидацию
     */
    public Student(String firstName, String lastName, String email, double grade) {
        nameValidation(firstName);
        nameValidation(lastName);
        emailValidation(email);
        gradeValidation(grade);

        count++;
        id = count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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
    public String getFirstName() {
        return firstName;
    }

    /**
     * Возвращает фамилию студента.
     *
     * @return фамилия студента
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Возвращает email студента.
     *
     * @return email студента
     */
    public String getEmail() {
        return email;
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
        gradeValidation(newGrade);
        this.grade = newGrade;
    }

    /**
     * Сравнивает двух студентов по уникальному идентификатору.
     *
     * <p>Два студента считаются равными, если у них одинаковый ID.</p>
     *
     * @param o объект для сравнения
     * @return true если ID совпадают, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;
        return id == student.getId();
    }

    /**
     * Возвращает хэш-код студента на основе ID.
     *
     * <p>Хэш-код согласован с equals(): одинаковые ID → одинаковый хэш.</p>
     *
     * @return хэш-код (равен значению ID)
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * Возвращает строковое представление студента.
     *
     * @return строка в формате
     *         "Student{id = 1, name = 'Иван Иванов', email = 'ivan@example.com', grade = 4.50"
     */
    @Override
    public String toString() {
        return String.format("Student{id = %d, name = '%s %s', email = '%s', grade = %.2f",
                id, firstName, lastName, email, grade);
    }

    /**
     * Проверяет корректность имени или фамилии.
     *
     * @param name имя для проверки
     * @throws IllegalArgumentException если имя null, пустое или состоит из пробелов
     */
    private void nameValidation(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Значение firstName и lastName не может быть пустым");
        }
    }

    /**
     * Проверяет корректность email.
     *
     * @param email email для проверки
     * @throws IllegalArgumentException если email null, пустой или не соответствует формату
     */
    private void emailValidation(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Значение поля email не может быть пустым");
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Некорректное значение поля email");
        }
    }

    /**
     * Проверяет корректность средней оценки.
     *
     * @param grade оценка для проверки
     * @throws IllegalArgumentException если оценка меньше 2.0 или больше 5.0
     */
    private void gradeValidation(double grade) {
        if (grade < 2.0 || grade > 5.0) {
            throw new IllegalArgumentException("Значение поля grade не может быть больше 5.0 и меньше 2.0");
        }
    }
}

