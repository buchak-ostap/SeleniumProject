package com.seleniumProject.pageObjects.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//*[text()='login']")
    private WebElement loginBtn;
    @FindBy(className = "profile-avatar")
    private WebElement profileIcon;
    @FindBy(xpath = "//*[@class='n-u-m__menu']/md-menu-item[3]")
    private WebElement logoutBtn;

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
        profileIcon.click();
    }

    public void clickLogout() {
        logoutBtn.click();
    }
}
