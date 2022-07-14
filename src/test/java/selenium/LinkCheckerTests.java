package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static selenium.LangSpecificLocators.LocatorByLang.*;

public class LinkCheckerTests {
    public static WebDriver driver;
    private static final By BTN_ACCEPTCOOKIE =
            By.xpath("//span[@class='block' and text()='" + ACCEPT_COOKIE.getByLang() + "']");
    private static final By LINK_HREFS = By.cssSelector("a");
    private static final By TEXTBOX_TOFIELD_FIELD = By.xpath("//div[@data-selector = 'toAddress']");
    private static final By TEXTBOX_TOFIELD = By.xpath("//div[@data-selector = 'toAddress']//input");
    private static final By LIST_FROMADDR =
            By.xpath("//div[@class='j-web-addresses-desktop-tab__address-title']");
    private static final By DRPDOWN_PACKAGETYPE =
            By.xpath(
                    "//input[@aria-label='"
                            + PACKAGING_TYPE.getByLang()
                            + "']/ancestor::div[contains(@class,'dropdown')]");
    private static final By SLCT_PACKAGETYPE =
            By.xpath("//div[contains(@class,'main-landing-card__dropdown-field')]");
    private static final List<String> LIST_PKGTYPES =
            Arrays.asList(
                    PARCEL.getByLang(),
                    PALLET.getByLang(),
                    DOCUMENT.getByLang(),
                    TIRE.getByLang(),
                    BULKY_GOODS.getByLang(),
                    NS_PALLET.getByLang(),
                    SUITCASE.getByLang());
    String url = "https://jumingo.com/de-de/";

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        //WebDriverManager.chromedriver().setup();
        driver = new SafariDriver();
                //new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }
    @Test
    public void dest() throws InterruptedException {
        driver.findElement(BTN_ACCEPTCOOKIE).click();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@aria-label='Nach']")).sendKeys("usa");
    }

    @Test (enabled = false)
    public void enterDest()  throws InterruptedException {
        String pkgType = "Koffer";

        driver.findElement(BTN_ACCEPTCOOKIE).click();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
       /* driver.findElement(TEXTBOX_TOFIELD_FIELD).click();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.findElement(TEXTBOX_TOFIELD).sendKeys("France");

        driver.findElements(LIST_FROMADDR).get(1).click();

        driver.findElement(DRPDOWN_PACKAGETYPE).click();
       List<WebElement> packDropdown =  driver.findElements(SLCT_PACKAGETYPE);
       for(WebElement el: packDropdown){
           if(el.getText().contains(pkgType)){
               el.click();
           } else{
               System.out.println("Not there");
           }
       }*/
        driver.findElement(DRPDOWN_PACKAGETYPE).click();

        driver.findElements(SLCT_PACKAGETYPE).stream()
                .filter(elt -> LIST_PKGTYPES.contains(elt.getText()))
                .filter(elt -> pkgType.contains(elt.getText()))
                .findFirst()
                .ifPresent(
                        elt -> {
                            elt.click();
                            System.out.println( elt.getText());
                        });


    }
    @Test(priority=0, enabled = false)
    public void linkCheckerTest() throws InterruptedException {
        driver.findElement(BTN_ACCEPTCOOKIE).click();

        List<WebElement> allLinks = driver.findElements(LINK_HREFS);
        System.out.println(allLinks.size());
        List<String> hrefLink = allLinks.stream().map(elt -> elt.getAttribute("href"))
                //.map(s->s.substring(s.indexOf("/de-")))
                .collect(Collectors.toList());

        hrefLink.stream().forEach(s->System.out.println(s));
        //click
    }

    //@AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
