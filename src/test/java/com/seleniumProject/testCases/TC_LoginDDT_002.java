package com.seleniumProject.testCases;

import com.seleniumProject.pageObjects.LoginPage;
import com.seleniumProject.utilities.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class TC_LoginDDT_002 extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void loginDDT(String email, String password) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(email);
        loginPage.setPassword(password);

        loginPage.clickLogin();
        Thread.sleep(2000);

        if (driver.getTitle().equals("Home")) {
            assertTrue(true);
            logger.info("User logged in to the system");
        } else {
            captureScreen(driver, "loginTest");
            driver.navigate().refresh();
            Thread.sleep(2000);
            fail("Title is different");
        }
    }



    @DataProvider(name = "LoginData")
    Object[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/com/seleniumProject/testData/Book1.xlsx";
        int rowNum = XLUtils.getRowCount(path, "Sheet1");
        int colCount = XLUtils.getCellCount(path, "Sheet1", 1);

        String[][] loginData = new String[rowNum][colCount];

        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colCount; j++) {
                loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        return loginData;
    }
}
