package com.seleniumProject.testCases.smoke;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.steps.calendar.Calendar;
import com.seleniumProject.steps.login.Login;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarSmokeTest extends BaseTest {

    Login login = new Login();
    Calendar calendar = new Calendar();

    @BeforeMethod
    public void loginToTheSystem() {
        login.loginToTheSystem(email, password);
    }

    @Test
    public void calendarSmokeTest() {
        calendar.openCalendarPage();
    }
}
