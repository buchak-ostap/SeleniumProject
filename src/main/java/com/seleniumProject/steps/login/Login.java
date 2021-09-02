package com.seleniumProject.steps.login;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.pageObjects.login.LoginPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BaseTest {

    public static final String HOME_PAGE_TITLE = "Home";

    LoginPage loginPage = new LoginPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Step
    public void login() {
        wait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getEmailIdentifier()));

        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        wait.until(ExpectedConditions.titleIs(HOME_PAGE_TITLE));
    }

    @Step
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getProfileIconIdentifier()));
        loginPage.clickProfileAvatar();
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLogoutBtnIdentifier()));
        loginPage.clickLogout();
    }
}
