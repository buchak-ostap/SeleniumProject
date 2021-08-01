import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "//Users//ostapbuchak//Desktop//MyProjectFiles//chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://space.sombrainc.com/");
        System.out.println(driver.getTitle());

        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("ostap.buchak@sombrainc.com");
        driver.findElement(By.id("password")).sendKeys("S1@R9t!cc");
        driver.findElement(By.xpath("//*[text()='login']")).click();
        Thread.sleep(2000);

//        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/md-sidenav/div/div[2]/div[1]/div[2]/button")).click();
//        Thread.sleep(2000);
//
//        driver.findElement(By.id("search_input")).sendKeys("Ostap");
        //TODO check git connection

        driver.quit();
    }
}
