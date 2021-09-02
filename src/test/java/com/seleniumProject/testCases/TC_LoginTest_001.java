package com.seleniumProject.testCases;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.pageObjects.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class TC_LoginTest_001 extends BaseTest {

    public static final String HOME_PAGE_TITLE = "Home";

    @Test
    public void loginTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("email"))));

        Thread.sleep(2000);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        Thread.sleep(2000);

        assertEquals(driver.getTitle(), HOME_PAGE_TITLE, "Title is different");

        loginPage.clickProfileAvatar();
        Thread.sleep(2000);
        loginPage.clickLogout();
        Thread.sleep(2000);
    }
}
