package com.seleniumProject.pageObjects.projects;

import com.seleniumProject.pageObjects.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage extends BaseTest {

    public ProjectsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class, 'closed-bar-button-title') and text() = 'Projects']")
    private WebElement sideMenuProjectsBtn;

    public void openProjectsPage() {
        waitForPageLoad();
        clickOn(sideMenuProjectsBtn);
        waitForPageLoad();
    }
}
