package com.seleniumProject.pageObjects.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
