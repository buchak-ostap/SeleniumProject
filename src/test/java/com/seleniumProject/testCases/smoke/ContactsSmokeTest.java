package com.seleniumProject.testCases.smoke;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.steps.contacts.Contacts;
import com.seleniumProject.steps.login.Login;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsSmokeTest extends BaseTest {

    Login login = new Login();
    Contacts contacts = new Contacts();

    @BeforeMethod
    public void loginToTheSystem() {
        login.loginToTheSystem(email, password);
    }

    @Test
    public void contactsSmokeTest() {
        contacts.openContactsPage();
    }
}
