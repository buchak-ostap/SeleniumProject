package com.seleniumProject.pageObjects.calendar;

import com.seleniumProject.pageObjects.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.seleniumProject.utilities.constants.Constants.TIMEOUT_M;

public class CalendarPage extends BaseTest {

    public CalendarPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@aria-label='TimeLog']")
    private WebElement sideMenuCalendarBtn;
    @FindBy(xpath = "//*[@class='pc-today']")
    private WebElement todayDay;
    @FindBy(xpath = "//*[@id='project']")
    private WebElement projectsList;
    @FindBy(xpath = "//*[@class='md-select-menu-container md-active md-clickable']//*[contains(text(), 'My Advisor')]")
    private WebElement selectProject;
    @FindBy(id = "description")
    private WebElement setTimeLogDescription;
    @FindBy(xpath = "//*[@class='res-table-body']/div[2]/div[2]")
    private WebElement getTimeLogDescription;
    @FindBy(xpath = "//*[@aria-label='close']")
    private WebElement closeCreatedTimeLog;
    @FindBy(xpath = "//*[text()='Save']")
    private WebElement timeLogSaveBtn;

    public void openCalendar() {
        waitFor(sideMenuCalendarBtn);
        clickOn(sideMenuCalendarBtn);
        waitForPageLoad();
    }

    public void openTimeLogWindow() {
        waitFor(todayDay);
        clickOn(todayDay);
        waitForPageLoad();
    }

    public void expandProjectsList() {
        waitFor(projectsList);
        clickOn(projectsList);
        waitForPageLoad();
    }

    public void selectProject() {
        waitFor(selectProject);
        clickOn(selectProject);
        waitForPageLoad();
    }

    public void enterDescription(String description) {
//        setTimeLogDescription.sendKeys(description);
        typeSlowly(setTimeLogDescription, description);
        waitABit(TIMEOUT_M);
    }

    public String getTimeLogDescription() {
        waitFor(getTimeLogDescription);
        return getTimeLogDescription.getText();
    }

    public void closeCreatedTimeLogWindow() {
        waitFor(closeCreatedTimeLog);
        clickOn(closeCreatedTimeLog);
        waitForPageLoad();
    }

    public void saveTimeLog() {
        waitFor(timeLogSaveBtn);
        clickOn(timeLogSaveBtn);
    }

}