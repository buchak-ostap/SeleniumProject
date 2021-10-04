package com.seleniumProject.pageObjects;

import com.seleniumProject.util.ReadConfig;
import com.seleniumProject.util.constants.JsScripts;
import com.seleniumProject.util.constants.RegularExpressions;
import lombok.extern.log4j.Log4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.seleniumProject.util.constants.Constants.TIMEOUT_S;

@Log4j()
public class BaseTest<T extends BaseTest<T>> extends PageObject {

    ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getSSBaseUrl();
    public String email = readConfig.getSSEmail();
    public String password = readConfig.getSSPassword();
    @Managed()
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {
        logger = Logger.getLogger("SS");
        PropertyConfigurator.configure("Log4j.properties");

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        this.setDriver(driver);
        getDriver().get(baseURL);
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
    }

    public void captureScreen(WebDriver driver, String name) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + name + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public WebElementFacade waitFor(WebElement element) {
        try{
            return super.waitFor(element);
        } catch (TimeoutException ex) {
            throw ex;
        }
    }

    @Override
    public void clickOn(WebElement element) {
        try{
            super.clickOn(element);
        } catch (Exception ex) {
            log.info("page initializing exception triggered on: " + getDriver().getCurrentUrl());
            PageFactory.initElements(getDriver(), element);
            element.click();
        }
    }

    public Long waitForPageLoad() {
        waitUntil((ExpectedCondition<Boolean>) driver -> ((JavascriptExecutor)driver).executeScript(JsScripts.getPageCompleteState).equals("complete")) ;
        waitABit(TIMEOUT_S);
        return (Long) ((JavascriptExecutor)getDriver()).executeScript(
                JsScripts.getPageLoadTimeInMs);
    }

    public <V> V waitUntil(Function<? super WebDriver, V> isTrue) {
        return doWait().until(isTrue);
    }

    public void waitABit(long mils) {
        super.waitABit((int) mils);
    }

    public FluentWait<WebDriver> doWait() {
        this.setDriver(driver);
        return (new FluentWait<>(getDriver()))
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .ignoring(NoSuchFrameException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(InvalidElementStateException.class)
                ;
    }

    public void typeSlowly(WebElement element, String text) {
        element.clear();
        List<String> chars = Arrays.stream(text.split(RegularExpressions.bySymbol)).collect(Collectors.toList());
        chars.forEach(element::sendKeys);
    }
}
