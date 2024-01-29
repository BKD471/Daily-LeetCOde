package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lis {
    private int lis(int[] nums,int index,int prev_index,int[][] memo){
        if(index>=nums.length) return 0;
        if(memo[index][prev_index+1]!=-1) return memo[index][prev_index+1];
        int take=0;
        if(prev_index==-1 || nums[index]>nums[prev_index]){
            take=1+lis(nums,index+1,index,memo);
        }
        int not_take=lis(nums,index+1,prev_index,memo);
        return memo[index][prev_index+1]=Math.max(take,not_take);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] memo=new int[n+1][n+1];

        for(int i=0;i<=n;i++) Arrays.fill(memo[i],-1);
        return lis(nums,0,-1,memo);
    }


    /*** BEST AAPROACH *****/
    private int upper_bound(List<Integer> nums,int key){
        int l=0,h=nums.size()-1,best=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums.get(mid)>=key){
                best=mid;
                h=mid-1;
            }else l=mid+1;
        }
        return best;
    }
    public int lengthOfLISBest(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        List<Integer> lis=new ArrayList<>();
        lis.add(nums[0]);

        for(int i=1;i<n;i++){
            if(nums[i]>lis.get(lis.size()-1)) lis.add(nums[i]);
            else{
                int index=upper_bound(lis,nums[i]);
                lis.set(index,nums[i]);
            }
        }
        return lis.size();
    }
}
