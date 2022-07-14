package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTesting {
   // WebDriver driver;
        static AppiumDriver<MobileElement> driver;

        @BeforeClass
        public void setUp() throws MalformedURLException {
            //Set up desired capabilities and pass the Android app-activity and app-package to Appium
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("BROWSER_NAME", "Android");
            capabilities.setCapability("platformVersion", "11");
            capabilities.setCapability("udid","RZ8R81K4VKP");
            capabilities.setCapability("deviceName","AndroidDevice");
            capabilities.setCapability("platformName","Android");


          //  capabilities.setCapability("appPackage", "com.android.calculator2");
            capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
// This package name of your app (you can get it from apk info app)
            //capabilities.setCapability("appActivity","com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
            capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
//Create RemoteWebDriver instance and connect to the Appium server
            //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
            //driver = new RemoteWebDriver(new URL("https://127.0.0.1:4723/wd/hub"), capabilities);
            driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            System.out.println("Application started");
        }

        @Test(enabled = false)
        public void testCal() throws Exception {
            //locate the Text on the calculator by using By.name()
          System.out.println("Started");
          //  MobileElement elt = driver.findElement(By.name("2"));

            MobileElement two= driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_09");
            two.click();
            MobileElement plus=driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Plus\"]"));
            plus.click();
            MobileElement four=driver.findElement(By.id("calc_keypad_btn_04"));
            four.click();
            MobileElement equalTo=driver.findElement(By.id("calc_keypad_btn_equal"));
            equalTo.click();
            //locate the edit box of the calculator by using By.tagName()
            MobileElement results=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
            //Check the calculated value on the edit box
            assert results.getText().equals("13"):"Actual value is : "+results.getText()+" did not match with expected value: 6";



        }

        @AfterClass
        public void teardown(){
            //close the app
            driver.quit();
            //driver.quit();
        }

}
