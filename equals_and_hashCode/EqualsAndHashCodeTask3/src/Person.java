import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Класс, представляющий человека с паспортными данными.
 * <p>
 * Объекты этого класса неизменяемы (immutable). Для сравнения объектов
 * используются серия и номер паспорта, что позволяет корректно определять
 * дубликаты в коллекциях.
 * </p>
 */

public class Person {

    private final String passportSeries;
    private final String passportNumber;
    private final String fullName;
    private final LocalDate birthDate;

    private static final Pattern PASSPORT_SERIES_VAL = Pattern.compile("^\\d{4}$");
    private static final Pattern PASSPORT_NUMBER_VAL = Pattern.compile("^\\d{6}$");

    /**
     * Конструктор класса Person с валидацией всех полей.
     *
     * @param passportSeries серия паспорта (4 цифры)
     * @param passportNumber номер паспорта (6 цифр)
     * @param fullName полное имя человека
     * @param birthDate дата рождения (не может быть null)
     * @throws IllegalArgumentException если любое из полей не проходит валидацию
     */
    public Person(String passportSeries, String passportNumber, String fullName, LocalDate birthDate) {
        passportSeriesValidation(passportSeries);
        passportNumberValidation(passportNumber);
        fullNameValidation(fullName);
        birthDateValidation(birthDate);

        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    /**
     * Возвращает серию паспорта.
     *
     * @return серия паспорта в виде строки из 4 цифр
     */
    public String getPassportSeries() {
        return passportSeries;
    }

    /**
     * Возвращает номер паспорта.
     *
     * @return номер паспорта в виде строки из 6 цифр
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * Возвращает полное имя человека.
     *
     * @return полное имя
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Возвращает дату рождения.
     *
     * @return дата рождения
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Сравнивает текущий объект с указанным объектом на равенство.
     * <p>
     * Два объекта Person считаются равными, если у них совпадают серия и номер паспорта.
     * Остальные поля (ФИО, дата рождения) не учитываются при сравнении.
     * </p>
     *
     * @param o объект для сравнения
     * @return true если объекты равны, false в противном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;
        return passportSeries.equals(person.getPassportSeries()) &&
                passportNumber.equals(person.getPassportNumber());
    }

    /**
     * Возвращает хеш-код объекта на основе серии и номера паспорта.
     * <p>
     * Метод согласован с {@link #equals(Object)}: если два объекта равны,
     * их хеш-коды также должны быть равны.
     * </p>
     *
     * @return хеш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passportSeries, passportNumber);
    }

    /**
     * Возвращает строковое представление объекта Person.
     *
     * @return отформатированная строка с информацией о человеке
     */
    @Override
    public String toString() {
        return String.format("Имя: %s, Дата рождения: %s, Серия и номер паспорта: %s %s",
                fullName, birthDate.toString(), passportSeries, passportNumber);
    }

    /**
     * Проверяет валидность серии паспорта.
     *
     * @param passportSeries проверяемая серия паспорта
     * @throws IllegalArgumentException если серия null, пустая или не соответствует формату 4 цифр
     */
    private void passportSeriesValidation(String passportSeries) {
        if (passportSeries == null || passportSeries.isBlank()) {
            throw new IllegalArgumentException("Значение поля passportSeries не может быть пустым");
        }
        if (!PASSPORT_SERIES_VAL.matcher(passportSeries).matches()) {
            throw new IllegalArgumentException("Значение поля passportSeries должно состоять из 4 чисел");
        }
    }

    /**
     * Проверяет валидность номера паспорта.
     *
     * @param passportNumber проверяемый номер паспорта
     * @throws IllegalArgumentException если номер null, пустой или не соответствует формату 6 цифр
     */
    private void passportNumberValidation(String passportNumber) {
        if (passportNumber == null || passportNumber.isBlank()) {
            throw new IllegalArgumentException("Значение поля passportNumber не может быть пустым");
        }
        if (!PASSPORT_NUMBER_VAL.matcher(passportNumber).matches()) {
            throw new IllegalArgumentException("Значение поля passportNumber должно состоять из 6 цифр");
        }
    }

    /**
     * Проверяет валидность ФИО.
     *
     * @param fullName проверяемое ФИО
     * @throws IllegalArgumentException если ФИО null или пустое
     */
    private void fullNameValidation(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Значение поля fullName не может быть пустым");
        }
    }

    /**
     * Проверяет валидность даты рождения.
     *
     * @param date проверяемая дата рождения
     * @throws IllegalArgumentException если дата null
     */
    private void birthDateValidation(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Полу birthDate не может быть пустым");
        }
    }
}
