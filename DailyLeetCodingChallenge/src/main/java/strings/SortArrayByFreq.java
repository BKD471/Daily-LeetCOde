package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayByFreq {
    public class SortArrayByFrequency {
        class Pair{
            char ch;
            int count;
            Pair(char ch,int count){
                this.ch=ch;
                this.count=count;
            }
        }
        public String frequencySort(String s) {
            int n=s.length();
            Map<Character,Integer> hash=new HashMap<>();
            for(int i=0;i<n;i++) hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i),0)+1);


            Comparator<Pair> sortByFreqDesc=(Pair a, Pair b)-> a.count>b.count?-1:a.count<b.count?1:0;
            List<Pair> freq=new ArrayList<Pair>();
            for(Map.Entry<Character,Integer> entry:hash.entrySet()){
                freq.add(new Pair(entry.getKey(),entry.getValue()));
            }

            Collections.sort(freq,sortByFreqDesc);
            String res="";
            for(Pair p:freq){
                char ch=p.ch;
                int count=p.count;
                while(count>0){
                    res+=ch;
                    count--;
                }
            }
            return res;
        }
    }

}
