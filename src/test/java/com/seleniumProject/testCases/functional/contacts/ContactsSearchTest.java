package com.seleniumProject.testCases.functional.contacts;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.steps.contacts.Contacts;
import com.seleniumProject.steps.login.Login;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.seleniumProject.utilities.constants.Constants.SEARCH_USER;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactsSearchTest extends BaseTest {

    Login login = new Login();
    Contacts contacts = new Contacts();

    @BeforeMethod
    public void loginToTheSystem() {
        login.loginToTheSystem();
    }

    @Test
    public void contactsSearchTest() {
        contacts.openContactsPage();
        int usersSize = contacts.searchInContacts(SEARCH_USER);
        assertEquals(usersSize, 1);
        assertTrue(contacts.checkIfUserDisplaysInList());
    }

    @AfterMethod
    public void logoutFromTheSystem() {
        login.logoutFromTheSystem();
    }
}