package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeelTest {

    public static WebDriver driver;
    String url = "https://keel-stage.talentship.io";

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
        driver.get(url);
        Thread.sleep(2000);
    }
    public void usingJavaScriptExec(String webElt, String value){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementsByClassName('"+webElt+"')[0].value='"+value+"'");
    }
    @Test
    public void addToCart() throws InterruptedException{
        driver.findElement(By.id("fullWidth")).sendKeys("admin");
        driver.findElement(By.id("fullWidth-1")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(5000);
    }

  //  @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
