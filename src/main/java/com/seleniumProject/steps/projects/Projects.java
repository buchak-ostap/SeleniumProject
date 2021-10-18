package com.seleniumProject.steps.projects;

import com.seleniumProject.pageObjects.BaseTest;
import com.seleniumProject.pageObjects.projects.ProjectsPage;
import net.thucydides.core.annotations.Step;
import org.testng.Assert;

import static com.seleniumProject.util.constants.Constants.PROJECTS_PAGE_TITLE;

public class Projects extends BaseTest {

    ProjectsPage projects = new ProjectsPage(driver);

    @Step
    public void openProjectsPage() {
        projects.openProjectsPage();
        Assert.assertEquals(projects.getTitle(), PROJECTS_PAGE_TITLE, "Title is different");
    }
}
