package com.seleniumProject.pageObjects.login;

import com.seleniumProject.pageObjects.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.seleniumProject.utilities.constants.Constants.TIMEOUT_M;

public class LoginPage extends BaseTest {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@type='email']")
    private WebElement email;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement password;

    @FindBy(xpath = "//*[text()='LOGIN']")
    private WebElement loginBtn;

    @FindBy(className = "profile-avatar")
    private WebElement profileIcon;

    @FindBy(xpath = "//*[contains(text(),'Logout')]")
    private WebElement logoutBtn;

    public void enterEmail(String usersEmail) {
        waitForPageLoad();
        typeSlowly(email, usersEmail);
    }

    public void enterPassword(String usersPassword) {
        typeSlowly(password, usersPassword);
    }

    public void clickLogin() {
        clickOn(loginBtn);
    }

    public void clickProfileAvatar() {
        waitABit(TIMEOUT_M);
        clickOn(profileIcon);
    }

    public void clickLogout() {
        waitFor(logoutBtn);
        clickOn(logoutBtn);
    }
}
