package testFiles;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Simple {

    public static String lang = "val";
    public String getConvertedRate(String netprice, String  ExchangeRate, String ExcSurchargePercent){
        // [Price Netto] * [Währungen → Exchange Rate Eur] / (1 + [Währungen → Exchange Surcharge Percent] / 100)
        // 118.68 * 0.9954 / (1 + 3/100) = 118.68*0.9954/1.03
        float val = Float.valueOf(netprice) * Float.valueOf(ExchangeRate)/(1+(Float.valueOf(ExcSurchargePercent)/100));
        float dividepercent = 1+(Float.valueOf(ExcSurchargePercent)/100);
        float numerator = Float.valueOf(netprice) * Float.valueOf(ExchangeRate);
        float tot = numerator/dividepercent;
        System.out.println(numerator + " " +dividepercent + " "+ tot);
        return String.valueOf(val);
    }
    public static void main(String[] args) {

        System.out.println("Hello World!");
        String addr = "Selenium2, Shankar Sushel,Schaarsteinweg 61, DE - 25065 Bundestaat, T. +490102566898";
        addr.replace("T.","");
        List<String> allAddr = new ArrayList<>();
        allAddr.addAll(Arrays.asList(addr.split(",")));
        System.out.println(allAddr);
        String price = "22.230,50 €";
        price = price.replaceAll("[^\\d,]","").replace(",",".");
        System.out.println(price);

        int sum = 23530;
        String sumNum = NumberFormat.getNumberInstance(Locale.US).format(sum);
        System.out.println(NumberFormat.getIntegerInstance().format(sum));
        System.out.println(sum);
        String val = String.valueOf(sum)+",00 €";
        System.out.println(val);
        System.out.println(lang);
        updateCall();
        System.out.println(lang);

    }

    private static void updateCall() {
        lang="update";
    }
}
