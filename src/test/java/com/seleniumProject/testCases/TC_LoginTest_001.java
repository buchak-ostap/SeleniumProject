package com.seleniumProject.testCases;

import com.seleniumProject.pageObjects.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws InterruptedException, IOException {

        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        Thread.sleep(2000);

        if (driver.getTitle().equals("Home")) {
            assertTrue(true);
            logger.info("Login test passed");
        } else {
            captureScreen(driver, "loginTest");
            fail("Title is different");
        }

        loginPage.clickProfileAvatar();
        Thread.sleep(2000);
        loginPage.clickLogout();
        Thread.sleep(2000);
    }
}
