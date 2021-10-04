package com.seleniumProject.util;

import java.time.LocalDate;

public class DateConstants {

    public static int getCurrentDay() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getDayOfMonth();
    }

    public static int getNextDayDate() {
        return LocalDate.now().plusDays(1).getDayOfMonth();
    }

}
