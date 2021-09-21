package com.seleniumProject.utilities;

import java.time.LocalDate;

public class DateConstants {

    public static int getCurrentDay() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getDayOfMonth();
    }


}
