package testFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NewYearChaos {

    public static void minimumBribes(List<Integer> q) {
        int bribes = 0;
        for(int i =0; i<q.size(); i++){
            if(q.get(i)-(i+1)>2){
                System.out.println("Too chaotic");
                bribes=-1;
                break;
            } else if(q.get(i)-(i+1)<-2){
                System.out.println("Too chaotic");
                break;
            } else if (q.get(i)-(i+1)==1 || q.get(i)-(i+1) == 2 ){
                bribes+=q.get(i)-(i+1);
            }
        }
        if(bribes>0)
            System.out.println(bribes);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
