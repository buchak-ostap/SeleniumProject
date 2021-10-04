package com.seleniumProject.testCases.functional.authentication;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.steps.login.Login;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.seleniumProject.util.constants.Constants.INVALID_EMAIL;
import static com.seleniumProject.util.constants.Constants.INVALID_PASSWORD;

public class LoginLogoutTest extends BaseTest {

    @Test
    public void validLoginLogoutTest() throws IOException {

        Login login = new Login();

        try {
            login.loginToTheSystem(email, password);
            login.logoutFromTheSystem();
        } catch (AssertionError e) {
            captureScreen(driver,"Valid Credentials");
        }
    }

    @Test
    public void loginWithInvalidEmailTest() throws IOException {

        Login login = new Login();

        try {
            login.loginToTheSystem(INVALID_EMAIL, password);
        } catch (AssertionError e) {
            captureScreen(driver,"Invalid Email");
        }
    }

    @Test
    public void loginWithInvalidPasswordTest() throws IOException {

        Login login = new Login();

        try {
            login.loginToTheSystem(email, INVALID_PASSWORD);
        } catch (AssertionError e) {
            captureScreen(driver,"Invalid Password");
        }
    }
}
