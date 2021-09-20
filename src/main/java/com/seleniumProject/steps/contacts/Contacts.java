package com.seleniumProject.steps.contacts;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.pageObjects.contacts.ContactsPage;
import net.thucydides.core.annotations.Step;
import org.testng.Assert;

import static com.seleniumProject.utilities.constants.Constants.*;

public class Contacts extends BaseTest {

    ContactsPage contacts = new ContactsPage(driver);

    @Step
    public void openContactsPage() {
        contacts.openContactsPage();
        Assert.assertEquals(contacts.getTitle(), CONTACTS_PAGE_TITLE, "Title is different");
    }

    @Step
    public void openProfilePage() {
        contacts.openFirstUserProfilePage();
        Assert.assertEquals(contacts.getTitle(), CONTACT_PAGE_TITLE, "Title is different");
    }

    @Step
    public int changeNumberOfUsersPerPage(int numberOfUsers) {
        contacts.expandPaginationDropDown();
        switch (numberOfUsers) {
            case 10:
                contacts.selectTenUsersPerPage();
                break;
            case 25:
                contacts.selectTwentyFiveUsersPerPage();
                break;
            default:
                contacts.selectFiftyUsersPerPage();
                break;
        }
        return contacts.getNumberOfUsersPerPage().size();
    }

    @Step
    public int searchInContacts(String text) {
        contacts.searchInContacts(text);
        return contacts.getNumberOfUsersPerPage().size();
    }

    @Step
    public boolean checkIfUserDisplaysInList() {
        return contacts.checkIfUserDisplays();
    }
}
