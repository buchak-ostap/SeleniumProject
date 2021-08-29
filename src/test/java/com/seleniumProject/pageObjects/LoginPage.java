package com.seleniumProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "email")
    @CacheLookup
    WebElement email;

    @FindBy(id = "password")
    @CacheLookup
    WebElement password;

    @FindBy(xpath = "//*[text()='login']")
    @CacheLookup
    WebElement loginBtn;

    @FindBy(className = "profile-avatar")
    @CacheLookup
    WebElement profileIcon;

    @FindBy(xpath = "//*[@class='n-u-m__menu']/md-menu-item[3]")
    @CacheLookup
    WebElement logoutBtn;

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
