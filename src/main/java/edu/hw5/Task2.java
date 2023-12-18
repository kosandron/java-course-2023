package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Task2 {
    private static final int MAIN_DATE = 13;

    private Task2() {
    }

    public static List<LocalDate> getAll13thFridayInYear(int year) {
        LocalDate currentStartDate = LocalDate.of(year, 1, 1);

        LocalDate nextFriday = getNext13thFriday(currentStartDate);
        List<LocalDate> fridaysList = new ArrayList<>();

        while (nextFriday.getYear() == year) {
            fridaysList.add(nextFriday);
            nextFriday = getNext13thFriday(nextFriday);
        }

        return fridaysList;
    }

    private static LocalDate getNext13thFriday(LocalDate date) {
        if (date == null) {
            throw new NullPointerException();
        }

        LocalDate mainDateInMonth = date.getDayOfMonth() >= MAIN_DATE
            ? date.plusMonths(1).withDayOfMonth(MAIN_DATE)
            : date.withDayOfMonth(MAIN_DATE);
        while (mainDateInMonth.getDayOfWeek() != DayOfWeek.FRIDAY) {
            mainDateInMonth = mainDateInMonth.plusMonths(1);
        }

        return mainDateInMonth;
    }
}
