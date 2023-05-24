package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.*;

public class CalculatorPgObj {
    public static Map<CalcBtnEnum,String> BTNMAP = new EnumMap<>(CalcBtnEnum.class);
    public static Map<Integer,String> NUMMAP = new HashMap<>();
    public static AppiumDriver<MobileElement> driver;
    private static final String one= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_01";
    private static final String two= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_02";
    private static final String three= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_03";
    private static final String four= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_04";
    private static final String five= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_05";
    private static final String six= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_06";
    private static final String seven= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_07";
    private static final String eight= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_08";
    private static final String nine= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_09";
    private static final String zero= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_00";

    private static final String equals = "calc_keypad_btn_equal";
    private static final String clear = "calc_keypad_btn_clear";
    private static final String divide = "calc_keypad_btn_div";
    private static final String multiply = "calc_keypad_btn_mul";
    private static final String add = "calc_keypad_btn_add";
    private static final String subtract = "calc_keypad_btn_sub";
    private static final String paranthesis = "calc_keypad_btn_parenthesis";

    private static final String result = "calc_edt_formula";
    static{
        BTNMAP.put(CalcBtnEnum.CLEAR,clear);
        BTNMAP.put(CalcBtnEnum.DIVIDE,divide);
        BTNMAP.put(CalcBtnEnum.MINUS,subtract);
        BTNMAP.put(CalcBtnEnum.PLUS,add);
        BTNMAP.put(CalcBtnEnum.MULTIPLY,multiply);
        BTNMAP.put(CalcBtnEnum.PARANTHESIS,paranthesis);
        BTNMAP.put(CalcBtnEnum.EQUALS,equals);
        BTNMAP.put(CalcBtnEnum.RESULTS,result);

        NUMMAP.put(0,zero);
        NUMMAP.put(1,one);
        NUMMAP.put(2,two);
        NUMMAP.put(3,three);
        NUMMAP.put(4,four);
        NUMMAP.put(5,five);
        NUMMAP.put(6,six);
        NUMMAP.put(7,seven);
        NUMMAP.put(8, eight);
        NUMMAP.put(9,nine);

    }

    public List<Integer> getUnitNumbers(int i){
        List<Integer> numList = new ArrayList<>();
        while(i>0){
            int a = i%10;
            i=i/10;
            numList.add(a);
        }
        Collections.reverse(numList);
        return numList;
    }

 /*   public CalculatorPgObj clickBtn(CalcBtnEnum btn){
        driver.findElement(By.id(BTNMAP.get(btn))).click();
        return this;
    }

    public CalculatorPgObj clickNumber(int val){
        driver.findElement(By.xpath(NUMMAP.get(val))).click();
        return this;
    }

    public CalculatorPgObj clickNumber(List<Integer> num){
        for(int i: num){
            clickNumber(i);
        }
        return this;
    }


    public String clickResult() {
        return driver.findElement(By.id(BTNMAP.get(CalcBtnEnum.RESULTS))).getText();
    }*/

    /*public static void setDriver(AppiumDriver<MobileElement> driver) {
        CalculatorPgObj.driver = driver;
    }*/
}
