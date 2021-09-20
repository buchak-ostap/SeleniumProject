package com.seleniumProject.steps.login;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.pageObjects.login.LoginPage;
import net.thucydides.core.annotations.Step;
import org.testng.Assert;

import static com.seleniumProject.utilities.constants.Constants.*;

public class Login extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);

    @Step
    public void loginToTheSystem() {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        waitABit(TIMEOUT_M);
        Assert.assertEquals(loginPage.getTitle(), HOME_PAGE_TITLE, "Title is different");
    }

    @Step
    public void logoutFromTheSystem() {
        loginPage.clickProfileAvatar();
        loginPage.clickLogout();
    }
}
