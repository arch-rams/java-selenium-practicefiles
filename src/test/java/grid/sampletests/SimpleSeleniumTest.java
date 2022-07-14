package grid.sampletests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SimpleSeleniumTest {
    @Test
    public void driverTest() throws MalformedURLException {

        //WebDriverManager.chromedriver().setup();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(BrowserType.CHROME);
        //ChromeOptions opt = new ChromeOptions();
        //opt.addArguments("--headless");
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);

   //     WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("remote webdriver connection"+ Keys.ENTER);
        System.out.println("The driver title is: "+driver.getTitle());
        driver.quit();
    }

}
