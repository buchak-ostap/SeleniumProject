package com.seleniumProject.steps.calendar;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.pageObjects.calendar.CalendarPage;
import net.thucydides.core.annotations.Step;

import static org.testng.Assert.assertEquals;


public class Calendar extends BaseTest {

    CalendarPage calendar = new CalendarPage(driver);

    @Step
    public void openCalendarPage() {
        calendar.openCalendarPage();
    }

    @Step
    public void selectAnyDay(int day) {
        calendar.selectDay(day);
    }

    @Step
    public void saveCurrentDayDefaultTimeLog(String description) {
        calendar.openTimeLogWindow();
        calendar.expandProjectsList();
        calendar.selectProject();
        calendar.enterTimeLogDescription(description);
        calendar.saveTimeLogOrRequest();
    }

    @Step
    public void verifyCurrentDayDefaultTimeLogCreation(String timeLogDescription) {
        calendar.openTimeLogWindow();
        String actual = calendar.getTimeLogDescription();
        assertEquals(actual, timeLogDescription, "Time Log description is different");
        calendar.closeTimeLogOrRequestWindow();
    }

    @Step
    public void enterRequestDescription(String description) {
        calendar.enterRequestDescription(description);
        //TODO need to change to submit
        calendar.closeTimeLogOrRequestWindow();
    }

    @Step
    public void selectVacationRequest() {
        calendar.selectVacationRequest();
    }

    @Step
    public void closeTimeLogOrRequestWindow() {
        calendar.closeTimeLogOrRequestWindow();
    }
}
