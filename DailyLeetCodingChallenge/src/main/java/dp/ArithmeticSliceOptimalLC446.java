package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArithmeticSliceOptimalLC446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        List<Map<Long,Integer>> hash=new ArrayList<>();
        for(int i=0;i<n;i++) hash.add(new HashMap<>());

        int res=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                long diff=(long)nums[i]-nums[j];

                if(diff<Integer.MIN_VALUE || diff>Integer.MAX_VALUE) continue;

                int count=hash.get(j).containsKey(diff)? hash.get(j).get(diff):0;
                res+=count;
                hash.get(i).put(diff, hash.get(i).getOrDefault(diff,0)+count+1);
            }
        }
        return res;
    }
}
