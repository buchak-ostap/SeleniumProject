package com.seleniumProject.pageObjects.login;

import com.seleniumProject.pageObjects.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.seleniumProject.utilities.constants.Constants.TIMEOUT_M;

public class LoginPage extends BaseTest {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement email;
    private By emailIdentifier = By.id("email");

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//*[text()='login']")
    private WebElement loginBtn;

    @FindBy(className = "profile-avatar")
    private WebElement profileIcon;
    private By profileIconIdentifier = By.className("profile-avatar");

    @FindBy(xpath = "//*[@class='n-u-m__menu']/md-menu-item[3]")
    private WebElement logoutBtn;
    private By logoutBtnIdentifier = By.xpath("//*[@class='n-u-m__menu']/md-menu-item[3]");

    public By getEmailIdentifier() {
        return emailIdentifier;
    }

    public By getProfileIconIdentifier() {
        return profileIconIdentifier;
    }

    public By getLogoutBtnIdentifier() {
        return logoutBtnIdentifier;
    }

    public void setEmail(String userEmail) {
        email.sendKeys(userEmail);
    }

    public void setPassword(String userPass) {
        password.sendKeys(userPass);
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public void clickProfileAvatar() {
        waitABit(TIMEOUT_M);
        clickOn(profileIcon);
    }

    public void clickLogout() {
        waitForPageLoad();
        clickOn(logoutBtn);
    }
}
