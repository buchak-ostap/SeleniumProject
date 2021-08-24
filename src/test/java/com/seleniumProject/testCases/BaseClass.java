package com.seleniumProject.testCases;

import com.seleniumProject.utilities.ReadConfig;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getGuruUrl();
    public String email = readConfig.getGuruEmail();
    public String password = readConfig.getGuruPassword();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {
        logger = Logger.getLogger("SS");
        PropertyConfigurator.configure("Log4j.properties");

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
