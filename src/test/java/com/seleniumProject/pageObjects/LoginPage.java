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

//    @FindBy(id = "email")
    @FindBy(name = "uid")
    @CacheLookup
    WebElement email;

//    @FindBy(id = "password")
    @FindBy(name = "password")
    @CacheLookup
    WebElement password;

//    @FindBy(xpath = "//*[text()='login']")
    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement loginBtn;

    public void setEmail(String userEmail) {
        email.sendKeys(userEmail);
    }

    public void setPassword(String userPass) {
        password.sendKeys(userPass);
    }

    public void clickLogin() {
        loginBtn.click();
    }
}
