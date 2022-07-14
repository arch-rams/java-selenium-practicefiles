package grid.sampletests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.remote.BrowserType.*;

public class SeleniumGridTest {
    @Test
    public void testingDocker() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(CHROME);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
       // WebDriver driver = new RemoteWebDriver(new URL("http://172.17.0.2:4444/wd/hub"), cap);
        driver.get("http://www.google.com");
        System.out.println("The driver title is: " +driver.getTitle());
        driver.quit();

    }

}
