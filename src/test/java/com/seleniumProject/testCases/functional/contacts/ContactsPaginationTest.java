package com.seleniumProject.testCases.functional.contacts;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.steps.contacts.Contacts;
import com.seleniumProject.steps.login.Login;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.seleniumProject.util.constants.Constants.*;
import static com.seleniumProject.util.constants.Constants.FIFTY_USERS;
import static org.testng.Assert.assertEquals;

public class ContactsPaginationTest extends BaseTest {

    Login login = new Login();
    Contacts contacts = new Contacts();

    @BeforeMethod
    public void loginToTheSystem() {
        login.loginToTheSystem(email, password);
    }

    @Test
    public void contactsPaginationTest() {
        contacts.openContactsPage();
        assertEquals(contacts.changeNumberOfUsersPerPage(TEN_USERS), TEN_USERS);
        assertEquals(contacts.changeNumberOfUsersPerPage(TWENTY_FIVE_USERS), TWENTY_FIVE_USERS);
        assertEquals(contacts.changeNumberOfUsersPerPage(FIFTY_USERS), FIFTY_USERS);
    }
}
