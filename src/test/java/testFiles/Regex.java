package testFiles;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        //String tariffRate = "CHF 232,23.";
        String tariffRate = "1.091,27 Kč";

        Pattern pattern = Pattern.compile("([^0-9,.])");
        Matcher matcher = pattern.matcher(tariffRate);
        String val = tariffRate.replace(".","").replace(",",".");
        System.out.println(val);

        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
