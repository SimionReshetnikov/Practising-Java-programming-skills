package com.lessons.stream_task_five.processor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DateProcessor {

    private DateProcessor() {}

    /***
     * @param dates List<LocalDate> Список дат.
     * @return List<LocalDate> Список дат попадающий на выходной день.
     */
    public static List<LocalDate> getHolidaysDate(List<LocalDate> dates) {
        listDatesValidation(dates);
        return dates.stream()
                .filter(d -> d.getDayOfWeek() == DayOfWeek.SATURDAY || d.getDayOfWeek() == DayOfWeek.SUNDAY)
                .toList();
    }

    /***
     * @param dates List<LocalDate> Список дат.
     * @return LocalDate Самая поздняя дата в списке.
     */
    public static LocalDate getLatestDate(List<LocalDate> dates) {
        listDatesValidation(dates);
        return dates.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow();
    }

    /***
     * @param dates List<LocalDate> Список дат.
     * @return List<String> Список дат в формате "dd.MM.yyyy" для вывода в консоль в классе MainApp
     */
    public static List<String> convertListLocalDateIntoString(List<LocalDate> dates) {
        listDatesValidation(dates);
        return dates.stream()
                .map(d -> d.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .toList();
    }

    /***
     * @param dates List<LocalDate> Список дат.
     * @return Map<DayOfWeek, Long> Map с названием дня недели в качестве ключа и количеством дней в качестве значения
     */
    public static Map<DayOfWeek, Long> countDaysByDayOfWeek(List<LocalDate> dates) {
        listDatesValidation(dates);
        return dates.stream()
                .collect(Collectors.groupingBy(
                        LocalDate::getDayOfWeek,
                        Collectors.counting()
                ));
    }

    private static void listDatesValidation(List<LocalDate> dates) {
        if (dates == null || dates.isEmpty()) {
            throw new IllegalArgumentException("Передан пустой список дат.");
        }
    }
}
