package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataCrawlTypOne {
    public static WebDriver driver;
    String url = "https://www.bestrandoms.com/random-address-in-de";

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
    @Test(priority=0)
    public void crawlData() throws InterruptedException {

        List<String> addrList =
                driver.findElements(By.xpath("//li[@class='col-sm-6']/span"))
                        .stream().map(e->e.getText()).collect(Collectors.toList());
        List<String> addrTitleList = driver.findElements(By.xpath("//li[@class='col-sm-6']/span/b"))
                .stream().map(e->e.getText()).collect(Collectors.toList());

        Map<String, String> addrBlocks = zipToMap(addrTitleList, addrList);
        

    }
    public static <K, V> Map<K, V> zipToMap(List<K> keys, List<V> values) {
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(keys::get, values::get));
    }
}
