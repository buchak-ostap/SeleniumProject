package com.seleniumProject.steps.calendar;

import com.seleniumProject.pageObjects.calendar.CalendarPage;
import net.thucydides.core.annotations.Step;

import static com.seleniumProject.pageObjects.BaseTest.driver;

public class Calendar {

    CalendarPage calendar = new CalendarPage(driver);

    @Step
    public void openCalendar() {
        calendar.openCalendar();
    }
}
