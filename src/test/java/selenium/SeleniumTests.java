package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTests {

    public static WebDriver driver;
    String url = "https://jumingo.com/en-gb/";

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
        Thread.sleep(3000);
    }
    public void usingJavaScriptExec(String webElt, String value){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementsByClassName('"+webElt+"')[0].value='"+value+"'");
    }
    @Test
    public void addToCart() throws InterruptedException{
        driver.findElement(By.xpath("//span[@class='block' and text()='Accept']")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//input[@class='q-field__native q-placeholder'][0]")).sendKeys("germany");
    }

  //  @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
