package com.seleniumProject.testCases.functional.contacts;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.steps.contacts.Contacts;
import com.seleniumProject.steps.login.Login;
import org.testng.annotations.*;

import static com.seleniumProject.util.constants.Constants.*;

public class ContactsRedirectsTest extends BaseTest {

    Login login = new Login();
    Contacts contacts = new Contacts();

    @BeforeMethod
    public void loginToTheSystem() {
        login.loginToTheSystem(email, password);
    }

    @Test
    public void openProfilePageFromContacts() {
        contacts.openContactsPage();
        contacts.searchInContacts(SEARCH_USER);
        contacts.openProfilePage();
    }
}
