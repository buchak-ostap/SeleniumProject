package com.seleniumProject.testCases;

import com.seleniumProject.pageObjects.CalendarPage;
import com.seleniumProject.pageObjects.LoginPage;
import org.testng.annotations.Test;

public class TC_CreateTimeLog_003 extends BaseClass {

    @Test
    public void createTimeLog() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        Thread.sleep(2000);

        CalendarPage createTimeLog = new CalendarPage(driver);
        Thread.sleep(2000);
        createTimeLog.openCalendar();
        Thread.sleep(2000);
        createTimeLog.openTimeLogWindow();
        Thread.sleep(2000);
        createTimeLog.expandProjectsList();
        createTimeLog.selectProject();
        createTimeLog.enterDescription("Time log description");
        createTimeLog.saveTimeLog();
        Thread.sleep(2000);
        loginPage.clickLogout();

    }
}
