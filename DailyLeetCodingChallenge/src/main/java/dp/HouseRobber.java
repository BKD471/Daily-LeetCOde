package dp;

import java.util.Arrays;

public class HouseRobber {
    private int solve(int[] nums,int index,int[] memo){
        if(index>=nums.length) return 0;
        if(memo[index]!=-1) return memo[index];
        int take=nums[index]+solve(nums,index+2,memo);
        int not_take=solve(nums,index+1,memo);
        return memo[index]=Math.max(take,not_take);
    }
    public int rob(int[] nums) {
        int n=nums.length;

        int[] memo=new int[n];
        Arrays.fill(memo,-1);
        return solve(nums,0,memo);
    }
}
