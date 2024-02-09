package dp;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestDivisibleSets {
    class Solution {
        Map<String,List<Integer>> memo=new HashMap<>();
        private List<Integer> solve(int[] nums,int index,int prev_index,List<Integer> temp){
            if(memo.containsKey(index+":"+prev_index)) return  memo.get(index+":"+prev_index);
            if(index>=nums.length) {
                //memo.put(index+":"+prev_index+1,new ArrayList<>(temp));
                return new ArrayList<>(temp);
            }

            List<Integer> take=new ArrayList<>();
            if(prev_index==-1 || nums[index]%nums[prev_index]==0){
                temp.add(nums[index]);
                take=solve(nums,index+1,index,temp);
                temp.remove(temp.size()-1);
            }
            List<Integer> not_take=solve(nums,index+1,prev_index,temp);


            List<Integer> best=(take.size()>not_take.size())?  take:not_take;
            memo.put(index+":"+prev_index+1,best);
            return  best;
        }
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int n=nums.length;
            List<Integer> res=new ArrayList<>();
            Arrays.sort(nums);
            memo.clear();
            return solve(nums,0,-1,new ArrayList<>());
        }
    }
}
