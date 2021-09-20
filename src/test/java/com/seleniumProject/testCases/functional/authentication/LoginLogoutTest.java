package com.seleniumProject.testCases.functional.authentication;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.steps.login.Login;
import org.testng.annotations.Test;

public class LoginLogoutTest extends BaseTest {

    @Test
    public void loginTest() {

        Login login = new Login();

        login.loginToTheSystem();
        login.logoutFromTheSystem();
    }
}
