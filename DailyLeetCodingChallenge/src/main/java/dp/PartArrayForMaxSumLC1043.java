package dp;

import java.util.Arrays;

public class PartArrayForMaxSumLC1043 {
    private int solve(int[] nums,int index,int n,int k,int[] memo){
        if(index>=n) return 0;
        if(memo[index]!=-1) return memo[index];
        int mx=0,mxSum=0;
        for(int i=index;i<Math.min(n,index+k);i++){
            mx=Math.max(mx,nums[i]);
            int sum=mx*(i-index+1)+solve(nums,i+1,n,k,memo);
            mxSum=Math.max(mxSum,sum);
        }
        return memo[index]=mxSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] memo=new int[n];
        Arrays.fill(memo,-1);
        return solve(arr,0,n,k,memo);
    }
}
