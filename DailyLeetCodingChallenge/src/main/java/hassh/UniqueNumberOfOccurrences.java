package hassh;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int n=arr.length;

        Map<Integer,Integer> numbers=new HashMap<>();
        Map<Integer,Integer> count=new HashMap<>();
        for(int i=0;i<n;i++) numbers.put(arr[i],numbers.getOrDefault(arr[i],0)+1);

        for(int v:numbers.values()){
            if(count.containsKey(v)) return false;
            count.put(v,count.getOrDefault(v,0)+1);
        }
        return true;
    }
}
