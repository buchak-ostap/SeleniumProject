package com.seleniumProject.testCases.functional.calendar;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.steps.calendar.Calendar;
import com.seleniumProject.steps.login.Login;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.seleniumProject.util.constants.Constants.TIME_LOG_DESCRIPTION;


public class CreateDefaultTimeLogTest extends BaseTest {

    Login login = new Login();
    Calendar calendar = new Calendar();

    @BeforeMethod
    public void loginToTheSystem() {
        login.loginToTheSystem(email, password);
    }

    @Test
    public void createTimeLog() {
        calendar.openCalendarPage();
        calendar.saveCurrentDayDefaultTimeLog(TIME_LOG_DESCRIPTION);
        calendar.verifyCurrentDayDefaultTimeLogCreation(TIME_LOG_DESCRIPTION);
    }
}
