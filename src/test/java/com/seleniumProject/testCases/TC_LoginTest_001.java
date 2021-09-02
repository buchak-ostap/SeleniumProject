package com.seleniumProject.testCases;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.steps.login.Login;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseTest {

    @Test
    public void loginTest() {

        Login login = new Login();
        login.login();
        login.logout();
    }
}
