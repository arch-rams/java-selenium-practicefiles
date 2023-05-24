package testFiles;

public class DataComparison {
    public static void main(String[] args){
        String val = "1.780,00 €";
        String val2 = "16.03.23\n2212189KW4";
        val = val.replace(".","");
        System.out.println(val.replace(".",""));
        // System.out.println(Integer.parseInt(val.replace("[^0-9]","").trim()));
    }
}
