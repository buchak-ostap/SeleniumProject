package com.seleniumProject.testCases.smoke;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.steps.login.Login;
import com.seleniumProject.steps.projects.Projects;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectsSmokeTest extends BaseTest {

    Login login = new Login();
    Projects projects = new Projects();

    @BeforeMethod
    public void loginToTheSystem() {
        login.loginToTheSystem(email, password);
    }

    @Test
    public void projectsSmokeTest() {
        projects.openProjectsPage();
    }
}
