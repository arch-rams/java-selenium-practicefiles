package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import static appium.CalculatorPgObj.*;


public class AppiumTesting {
   // WebDriver driver;
        static AppiumDriver<MobileElement> driver;
        public CalculatorPgObj calcPg = new CalculatorPgObj();

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
          /*  setDriver(driver);*/
            System.out.println("Application started");
        }

        @Test(enabled = true)
        public void testCal() throws Exception {
            int i=0, j=0, output =0;
            //locate the Text on the calculator by using By.name()
          System.out.println("Started");
          //  MobileElement elt = driver.findElement(By.name("2"));
            System.out.println(" Addition function");
           // Scanner scan = new Scanner(System.in);
            System.out.println("Summing 2 integers: 45 & 36");
            //i=scan.nextInt();
            // j=scan.nextInt();
            output = addition(45,36);
            //output = addition(i,j);
            System.out.println("The value is: "+output);
            Assert.assertEquals(output,Math.addExact(45,36));

            System.out.println(" Subtractioni function");
            System.out.println("Subtraction of 2 integers: 2345 & 1369");
            output = subtraction(2345,1369);
            System.out.println("The value is: "+output);
            Assert.assertEquals(output,Math.subtractExact(2345,1369));
/*


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

*/


        }

    private int addition(int i, int j) {
            List<Integer> num1 = calcPg.getUnitNumbers(i);
            List<Integer> num2 = calcPg.getUnitNumbers(j);

            String result = clickNumber(num1)
                    .clickBtn(CalcBtnEnum.PLUS)
                    .clickNumber(num2)
                    .clickBtn(CalcBtnEnum.EQUALS)
                    .clickResult();
            return Integer.parseInt(result);
    }

    private int subtraction(int i, int j) {
        List<Integer> num1 = calcPg.getUnitNumbers(i);
        List<Integer> num2 = calcPg.getUnitNumbers(j);

        String result = clickNumber(num1)
                .clickBtn(CalcBtnEnum.MINUS)
                .clickNumber(num2)
                .clickBtn(CalcBtnEnum.EQUALS)
                .clickResult();
        return Integer.parseInt(result);
    }

    @AfterClass
        public void teardown(){
            //close the app
            driver.quit();
            //driver.quit();
        }

    public AppiumTesting clickBtn(CalcBtnEnum btn){
        driver.findElement(By.id(BTNMAP.get(btn))).click();
        return this;
    }

    public AppiumTesting clickNumber(int val){
        driver.findElement(By.id(NUMMAP.get(val))).click();
        return this;
    }

    public AppiumTesting clickNumber(List<Integer> num){
        for(int i: num){
            clickNumber(i);
        }
        return this;
    }


    public String clickResult() {
        return driver.findElement(By.id(BTNMAP.get(CalcBtnEnum.RESULTS))).getText();
    }

}
