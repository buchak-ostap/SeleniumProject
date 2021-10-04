package com.seleniumProject.pageObjects.contacts;

import com.seleniumProject.pageObjects.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.seleniumProject.util.constants.Constants.TIMEOUT_L;
import static com.seleniumProject.util.constants.Constants.TIMEOUT_M;

public class ContactsPage extends BaseTest {

    public ContactsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class, 'closed-bar-button-title') and text() = 'Contacts']")
    private WebElement sideMenuContactsBtn;

    @FindBy(xpath = "//*[@data-placeholder='Search']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@class='mat-row cdk-row ng-star-inserted']")
    private WebElement listOfUsers;

    @FindBy(xpath = "//*[@class='mat-select-trigger ng-tns-c131-20']")
    private WebElement paginationDropDownButton;

    @FindBy(xpath = "//*[@id='mat-select-2-panel']//*[contains(text(), '10')]")
    private WebElement tenItemsPerPage;

    @FindBy(xpath = "//*[@id='mat-select-2-panel']//*[contains(text(), '25')]")
    private WebElement twentyFiveItemsPerPage;

    @FindBy(xpath = "//*[@id='mat-select-2-panel']//*[contains(text(), '50')]")
    private WebElement fiftyItemsPerPage;

    @FindBy(xpath = "//*[contains(text(), ' arrow_forward')]")
    private WebElement openFirstUserProfilePage;

    @FindBy(xpath = "//*[contains(text(), 'Viktor ')]")
    private WebElement searchedUserName;

    public void openContactsPage() {
        waitForPageLoad();
        clickOn(sideMenuContactsBtn);
        waitForPageLoad();
        waitABit(TIMEOUT_M);
    }

    public void searchInContacts(String text) {
        clickOn(searchField);
        typeSlowly(searchField, text);
        waitABit(TIMEOUT_L);
    }

    public void expandPaginationDropDown() {
        waitForPageLoad();
        clickOn(paginationDropDownButton);
    }

    public void selectTenUsersPerPage() {
        waitFor(tenItemsPerPage);
        clickOn(tenItemsPerPage);
        waitForPageLoad();
    }

    public void selectTwentyFiveUsersPerPage() {
        waitFor(twentyFiveItemsPerPage);
        clickOn(twentyFiveItemsPerPage);
        waitForPageLoad();
    }

    public void selectFiftyUsersPerPage() {
        waitFor(fiftyItemsPerPage);
        clickOn(fiftyItemsPerPage);
        waitForPageLoad();
    }

    public List<WebElement> getNumberOfUsersPerPage() {
        List<WebElement> users = driver.findElements(By.xpath("//*[@class='mat-row cdk-row ng-star-inserted']"));
        return users;
    }

    public void openFirstUserProfilePage() {
        waitFor(openFirstUserProfilePage);
        clickOn(openFirstUserProfilePage);
        waitForPageLoad();
    }

    public boolean checkIfUserDisplays() {
        return searchedUserName.isDisplayed();
    }
}
