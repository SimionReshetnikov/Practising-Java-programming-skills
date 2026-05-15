package com.lessons.stream_task_five;

import com.lessons.stream_task_five.processor.DateProcessor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) {
        List<LocalDate> list = Arrays.asList(
                LocalDate.of(2026, 5, 11),
                LocalDate.of(2026, 5, 16),
                LocalDate.of(2026, 12, 17),
                LocalDate.of(2026, 5, 10),
                LocalDate.of(2026, 3, 8),
                LocalDate.of(2026, 7, 15),
                LocalDate.of(2026, 8, 3),
                LocalDate.of(2026, 10, 9),
                LocalDate.of(2026, 12, 22),
                LocalDate.of(2026, 3, 19),
                LocalDate.of(2026, 1, 26),
                LocalDate.of(2026, 2, 25),
                LocalDate.of(2026, 6, 29),
                LocalDate.of(2026, 5, 28),
                LocalDate.of(2026, 4, 1)
        );
        printListDate(DateProcessor.getHolidaysDate(list));
        System.out.println(DateProcessor.getLatestDate(list)
                .format(DateTimeFormatter.ofPattern("dd.MM.yy")));
        System.out.println("--------------------------------------------------------");

        for (String element : DateProcessor.convertListLocalDateIntoString(list)) {
            System.out.println(element);
        }
        System.out.println("--------------------------------------------------------");

        Map<DayOfWeek, Long> dayCount = DateProcessor.countDaysByDayOfWeek(list);
        for (Map.Entry<DayOfWeek, Long> entry : dayCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void printListDate(List<LocalDate> list) {
        for (LocalDate element : list) {
            System.out.println(element.format(DateTimeFormatter.ofPattern("dd.MM.yy")));
        }

        System.out.println("-----------------------------------------------------");
    }
}
