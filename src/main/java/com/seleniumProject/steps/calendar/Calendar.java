package com.seleniumProject.steps.calendar;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.pageObjects.calendar.CalendarPage;
import net.thucydides.core.annotations.Step;



public class Calendar extends BaseTest {

    CalendarPage calendar = new CalendarPage(getDriver());

    @Step
    public void openCalendar() {
        calendar.openCalendar();
    }
}
