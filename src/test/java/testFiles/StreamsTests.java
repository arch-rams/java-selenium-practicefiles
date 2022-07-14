package testFiles;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTests {
    public static void main(String[] args) {
        // printSumOfArrayVal();
       // freqOfWords(System.getProperty("user.dir")+"/src/test/resources/Paragraph.txt");
        //minInList();
        subStrOfList();
    }

    private static void minInList(){
        List<Integer> numList = Arrays.asList(1237, 456, 24, 63, 15, 27);
        Comparator<Integer> min = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        Optional<Integer> minOp =numList.stream().min(min);
        System.out.println(minOp.get());
    }
    private static void printSumOfArrayVal() {
        List<Integer> values = Arrays.asList(1,2,42,5,325,252,35,745,46);
        int sum = values.stream().reduce(0,(subtot, element)->subtot+element).intValue();
        int sum1 = values.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    private static void freqOfWords(String filePath){
        Map<String, Integer> wordFreq = new HashMap<>();
        try {
            InputStream stream = Files.newInputStream(Paths.get(filePath));
            String contents = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
            //System.out.println(contents);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void subStrOfList(){
        List<String> list = Arrays.asList(
                "https://www.jumingo.online/de-de/versandkostenrechner",
                "https://www.jumingo.online/de-de/sendungsverfolgung",
                "https://www.jumingo.online/de-de/support",
                "https://www.jumingo.online/de-de/sign-user",
                "https://www.jumingo.online/de-de/versandkostenrechner/paket"
        );
       List<String> tlist = list.stream()
               .map(s->s.substring(s.indexOf("/de")))
               .collect(Collectors.toList());
        tlist.stream().forEach(s->System.out.println(s));

        List<String> availLinks = new ArrayList<>();


    }
}
