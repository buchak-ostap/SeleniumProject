package com.seleniumProject.steps.calendar;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.pageObjects.calendar.CalendarPage;
import net.thucydides.core.annotations.Step;

import static org.testng.Assert.assertEquals;


public class Calendar extends BaseTest {

    CalendarPage calendar = new CalendarPage(driver);

    @Step
    public void openCalendar() {
        calendar.openCalendar();
    }

    @Step
    public void saveCurrentDayDefaultTimeLog(String description) {
        calendar.openTimeLogWindow();
        calendar.expandProjectsList();
        calendar.selectProject();
        calendar.enterDescription(description);
        calendar.saveTimeLog();
    }

    @Step
    public void verifyCurrentDayDefaultTimeLogCreation(String timeLogDescription) {
        calendar.openTimeLogWindow();
        String actual = calendar.getTimeLogDescription();
        assertEquals(actual, timeLogDescription, "Time Log description is different");
        calendar.closeCreatedTimeLogWindow();
    }
}
