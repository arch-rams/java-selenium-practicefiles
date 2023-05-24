package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoQATests {
    public static WebDriver driver;
    String url = "https://demoqa.com/";

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }
    @Test(priority=0)
    public void commonTests() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//div[@class='card mt-4 top-card']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
