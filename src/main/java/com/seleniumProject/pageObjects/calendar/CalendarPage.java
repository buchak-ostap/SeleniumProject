package com.seleniumProject.pageObjects.calendar;

import com.seleniumProject.pageObjects.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.seleniumProject.utilities.constants.Constants.TIMEOUT_M;

public class CalendarPage extends BaseTest {

    public CalendarPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='app']/ss-sidebar/div/div/div[1]/a[2]/span[1]/span")
    private WebElement sideMenuCalendarBtn;

    @FindBy(xpath = "//*[@class='pc-today']")
    private WebElement todayDay;

    @FindBy(xpath = "//*[@id='project']")
    private WebElement projectsList;

    @FindBy(xpath = "//*[@class='md-select-menu-container md-active md-clickable']//*[contains(text(), 'My Advisor')]")
    private WebElement selectProject;

    @FindBy(xpath = "//*[@id='description']")
    private WebElement timeLogDescription;

    @FindBy(xpath = "//*[starts-with(@id, 'input_')]")
    private WebElement requestDescription;

    @FindBy(xpath = "//*[@class='res-table-body']/div[2]/div[2]")
    private WebElement getTimeLogDescription;

    @FindBy(xpath = "//*[@aria-label='close']")
    private WebElement closeTimeLogOrRequestWindow;

    @FindBy(xpath = "//*[text()='Save']")
    private WebElement timeLogOrRequestSaveBtn;

    @FindBy(xpath = "//*[@for='color-2']")
    private WebElement vacationRadioBtn;


    public void selectDay(int day) {
        waitForPageLoad();
        WebElement dayBox = driver.findElement(By.xpath("//*[@class='day-container layout-column flex' and @tabindex='" + day + "']"));
        clickOn(dayBox);
        waitForPageLoad();
    }

    public void selectVacationRequest() {
        waitFor(vacationRadioBtn);
        clickOn(vacationRadioBtn);
    }

    public void openCalendarPage() {
        waitForPageLoad();
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

    public void enterTimeLogDescription(String description) {
        typeSlowly(timeLogDescription, description);
        waitABit(TIMEOUT_M);
    }

    public void enterRequestDescription(String description) {
        clickOn(requestDescription);
        typeSlowly(requestDescription, description);
        waitABit(TIMEOUT_M);
    }

    public void saveTimeLogOrRequest() {
        waitFor(timeLogOrRequestSaveBtn);
        clickOn(timeLogOrRequestSaveBtn);
    }

    public String getTimeLogDescription() {
        waitFor(getTimeLogDescription);
        return getTimeLogDescription.getText();
    }

    public void closeTimeLogOrRequestWindow() {
        waitFor(closeTimeLogOrRequestWindow);
        clickOn(closeTimeLogOrRequestWindow);
    }
}
