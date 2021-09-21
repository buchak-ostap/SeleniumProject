package com.seleniumProject.testCases.functional.calendar;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.steps.calendar.Calendar;
import com.seleniumProject.steps.login.Login;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.seleniumProject.utilities.DateConstants.getCurrentDay;
import static com.seleniumProject.utilities.constants.Constants.REQUEST_LOG_DESCRIPTION;

public class CreateVacationRequest extends BaseTest {

    Login login = new Login();
    Calendar calendar = new Calendar();

    @BeforeMethod
    public void loginToTheSystem() {
        login.loginToTheSystem();
    }

    @Test
    public void createTimeLog() {

        calendar.openCalendarPage();
        calendar.selectAnyDay(getCurrentDay());
        calendar.selectVacationRequest();
        calendar.enterRequestDescription(REQUEST_LOG_DESCRIPTION);
        calendar.closeTimeLogOrRequestWindow();
    }
}