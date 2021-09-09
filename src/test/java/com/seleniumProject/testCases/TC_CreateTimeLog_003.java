package com.seleniumProject.testCases;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.steps.calendar.Calendar;
import com.seleniumProject.steps.login.Login;
import org.testng.annotations.Test;

public class TC_CreateTimeLog_003 extends BaseTest {

    public static final String TIME_LOG_DESCRIPTION = "Work on PHN projects, test finished tickets, create automation tests";

    @Test
    public void createTimeLog() {

        Login login = new Login();
        Calendar calendar = new Calendar();

        login.login();

        calendar.openCalendar();
        calendar.saveCurrentDayDefaultTimeLog(TIME_LOG_DESCRIPTION);
        calendar.verifyCurrentDayDefaultTimeLogCreation(TIME_LOG_DESCRIPTION);

        login.logout();
    }
}
