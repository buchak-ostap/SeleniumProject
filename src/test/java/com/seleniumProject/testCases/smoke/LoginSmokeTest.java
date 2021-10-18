package com.seleniumProject.testCases.smoke;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.steps.login.Login;
import org.testng.annotations.Test;

public class LoginSmokeTest extends BaseTest {

    @Test
    public void loginSmokeTest() {

        Login login = new Login();

        login.loginToTheSystem(email, password);
    }
}
