package testFiles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FrequencyOfWords {

   public static void main(String[] args) {
      String s = "I am am this this I am this vaer very much thanks vaer much thanks";
      String[] split = s.split(" ");

      Map<String, Integer> freq = new LinkedHashMap<>();
      for(int i=0; i<split.length; i++){
         if(freq.containsKey(split[i])){
            int val = freq.get(split[i])+1;
            freq.put(split[i], val);
         } else{
            freq.put(split[i],1);
         }
      }
      Set<Map.Entry<String, Integer>> itr = freq.entrySet();
      for(Map.Entry<String, Integer> m : itr){
         System.out.println("Count of " + m.getKey() + " is " +m.getValue());
      }
   }

}
