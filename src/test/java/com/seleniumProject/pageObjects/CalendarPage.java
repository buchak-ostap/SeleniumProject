package com.seleniumProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {

    WebDriver ldriver;

    public CalendarPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//*[@aria-label='TimeLog']")
    @CacheLookup
    WebElement sideMenuCalendarBtn;

    @FindBy(xpath = "//*[@class='pc-today']")
    @CacheLookup
    WebElement todayDay;

    @FindBy(xpath = "//*[@ng-model='creating.timeLog.projectId']")
    @CacheLookup
    WebElement projectsList;

    @FindBy(xpath = "//*[@id=\"select_option_31\"]/div[1]")
    @CacheLookup
    WebElement selectProject;

    @FindBy(id = "description")
    @CacheLookup
    WebElement timeLogDescription;

    @FindBy(xpath = "//*[text()='Save']")
    @CacheLookup
    WebElement timeLogSaveBtn;

    public void openCalendar() {
        sideMenuCalendarBtn.click();
    }

    public void openTimeLogWindow() {
        todayDay.click();
    }

    public void expandProjectsList() {
        projectsList.click();
    }

    public void selectProject() {
        selectProject.click();
    }

    public void enterDescription(String description) {
        timeLogDescription.sendKeys(description);
    }

    public void saveTimeLog() {
        timeLogSaveBtn.click();
    }

}
