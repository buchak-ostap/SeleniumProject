package com.seleniumProject.testCases;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.pageObjects.calendar.CalendarPage;
import com.seleniumProject.pageObjects.login.LoginPage;
import com.seleniumProject.steps.calendar.Calendar;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.fail;

public class TC_CreateTimeLog_003 extends BaseTest {

    public static final String TIME_LOG_DESCRIPTION = "Work on PHN projects, test finished tickets, create automation tests";

    @Test
    public void createTimeLog() throws InterruptedException, IOException {

        LoginPage loginPage = new LoginPage(driver);
        CalendarPage createTimeLog = new CalendarPage(driver);

        Calendar calendar = new Calendar();

        Thread.sleep(2000);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLogin();
//        Thread.sleep(2000);

        calendar.openCalendar();
//        Thread.sleep(2000);
        createTimeLog.openTimeLogWindow();
//        Thread.sleep(2000);



        createTimeLog.expandProjectsList();
//        Thread.sleep(2000);
        createTimeLog.selectProject();


        createTimeLog.enterDescription(TIME_LOG_DESCRIPTION);
        createTimeLog.saveTimeLog();

        createTimeLog.openTimeLogWindow();
//        Thread.sleep(2000);
        String timeLogDescription = createTimeLog.getTimeLogDescription();
        if (timeLogDescription.equals(TIME_LOG_DESCRIPTION)) {
            Assert.assertTrue(true);
        } else {
            captureScreen(driver, "loginTest");
            fail("Time log not created");
        }

        createTimeLog.closeCreatedTimeLogWindow();
//        Thread.sleep(4000);
        loginPage.clickProfileAvatar();
//        Thread.sleep(2000);
        loginPage.clickLogout();

    }
}
