package dp;

import java.util.HashMap;
import java.util.Map;

public class MinOperationsToMakeArrEmptyLC2870 {
    private static final int MAX_VALUE=(int)(Math.pow(10,8));
    private int countToMinimize(int n){
        int[] dp=new int[n+1];
        dp[0]=MAX_VALUE;dp[1]=MAX_VALUE;
        if(n>=2) dp[2]=1;
        if(n>=3) dp[3]=1;

        for(int i=4;i<=n;i++) dp[i]=1+Math.min(dp[i-2],dp[i-3]);
        return dp[n];
    }
    public int minOperations(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<n;i++) hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);

        int res=0;
        for(int count:hash.values()){
            int cnt=countToMinimize(count);
            if(cnt==MAX_VALUE) return -1;
            res+=cnt;
        }
        return res;
    }

    public int minOperationsBest(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<n;i++) hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);

        int res=0;
        for(int count:hash.values()){
            if(count==1) return -1;
            res+=count/3;
            if(count%3!=0) res++;
        }
        return res;
    }
}
