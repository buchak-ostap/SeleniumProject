package com.seleniumProject.testCases;

import com.seleniumProject.pageObjects.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws InterruptedException {
        driver.get(baseURL);

        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        Thread.sleep(2000);

        if (driver.getTitle().equals("Home")) {
            assertTrue(true);
        } else {
            fail("Title is different");
        }
    }
}