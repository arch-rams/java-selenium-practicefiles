package grid.sampletests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Helper {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public static String remote_url_chrome = "http://localhost:4445/wd/hub";
    public static String remote_url_firefox = "http://localhost:4446/wd/hub";

    public void setupThread(String browserName) throws MalformedURLException
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            System.out.println("Inside Chrome");
            ChromeOptions options = new ChromeOptions();
            driver.set(new RemoteWebDriver(new URL(remote_url_chrome), options));
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            System.out.println("Inside Firefox");
            FirefoxOptions options = new FirefoxOptions();
            driver.set(new RemoteWebDriver(new URL(remote_url_firefox), options));
        }
    }

    public WebDriver getDriver()
    {
        return driver.get();
    }

    public void tearDownDriver()
    {
        getDriver().quit();
    }
}
