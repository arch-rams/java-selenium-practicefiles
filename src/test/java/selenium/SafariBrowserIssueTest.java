package selenium;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static selenium.LangSpecificLocators.LocatorByLang.ACCEPT_COOKIE;
import static selenium.LangSpecificLocators.LocatorByLang.COMPARERATES;

public class SafariBrowserIssueTest {
    public static WebDriver driver;
    private static final By BTN_COMPARERATES =
             By.xpath("//span[text()='Tarife vergleichen']");
           // By.xpath("//span[text()='" + COMPARERATES.getByLang() + "']");
    private static final By TEXTBOX_FROMFIELD =
            By.xpath("//div[@data-selector = 'fromAddress']//input");
    private static final By FIELD_FROMADDR = By.xpath("//div[@data-selector = 'fromAddress']");
    private static final By BTN_EDITBOX = By.xpath("(//div[@class='q-tab__label'])[2]");
    private static final By FIELD_TOADDR = By.xpath("//div[@data-selector='toAddress']");
    private static final By TEXTBOX_TOFIELD = By.xpath("//div[@data-selector = 'toAddress']//input");
    private static final By BTN_ACCEPTCOOKIE =
            By.xpath("//span[@class='block' and text()='" + ACCEPT_COOKIE.getByLang() + "']");
    private static final By FIELD_COUNTRYDROPDWN = By.xpath("//span[@placeholder='Select a country']//div");
    private static final By TXTBOX_COUNTRY = By.xpath("//input[@placeholder='Select a country']");
    private static final By BTN_DONE = By.xpath("//span[text()='Done']/..");
    String url = "https://jumingo.online/en-gb/";

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }
    @Test(priority=0)
    public void commonTests() throws InterruptedException {
       driver.findElement(BTN_ACCEPTCOOKIE).click();
        Thread.sleep(3000);
    }

    @Test(enabled = true)
    public void enterFromUsingEdit() throws InterruptedException {
        driver.findElement(FIELD_FROMADDR).click();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        //driver.findElement(TEXTBOX_FROMFIELD).sendKeys("united kingdom");
        driver.findElement(BTN_EDITBOX).click();
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", driver.findElement(FIELD_COUNTRYDROPDWN));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        driver.findElement(FIELD_COUNTRYDROPDWN).click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

        driver.findElement(TXTBOX_COUNTRY).clear();
        driver.findElement(TXTBOX_COUNTRY).sendKeys("usa");
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[contains(@class,'q-item__section')]/span[text()='USA']")).click();
/*

        Actions action = new Actions(driver);
        WebElement searchresult = driver.findElement(By.xpath("//input[@type='search']"));
        action.click(searchresult);
*/
        Uninterruptibles.sleepUninterruptibly(4,TimeUnit.SECONDS);
        driver.findElement(BTN_DONE).click();
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        driver.findElement(BTN_COMPARERATES).click();
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void enterFromUsingJavaScript() throws InterruptedException {
        driver.findElement(FIELD_FROMADDR).click();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        driver.findElement(TEXTBOX_FROMFIELD).clear();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement fromText = driver.findElement(TEXTBOX_FROMFIELD);
        js.executeScript("document.getElementsByClassName('q-field__native q-placeholder')[0].value='italy'",fromText);
        driver.findElement(FIELD_FROMADDR).click();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        driver.findElement(BTN_COMPARERATES).click();

    }


    @Test(enabled = false)
    public void enterToUsingWebSearch() throws InterruptedException {
        driver.findElement(FIELD_TOADDR).click();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
     //   driver.findElement(TEXTBOX_TOFIELD).clear();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement toText = driver.findElement(TEXTBOX_TOFIELD);
        js.executeScript("document.getElementsByClassName('q-field__native q-placeholder')[1].value='italy'",toText);
        //driver.findElement(TEXTBOX_TOFIELD).click();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        driver.findElement(BTN_COMPARERATES).click();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("shipping"));
    }

    @Test(enabled = false)
    public void enterFromUsingWebSearch() throws InterruptedException {
        driver.findElement(FIELD_FROMADDR).click();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        //   driver.findElement(TEXTBOX_TOFIELD).clear();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement toText = driver.findElement(TEXTBOX_FROMFIELD);
        js.executeScript("document.getElementsByClassName('q-field__native q-placeholder')[0].value='germany'",toText);
        //driver.findElement(TEXTBOX_TOFIELD).click();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        driver.findElement(BTN_COMPARERATES).click();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("shipping"));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
