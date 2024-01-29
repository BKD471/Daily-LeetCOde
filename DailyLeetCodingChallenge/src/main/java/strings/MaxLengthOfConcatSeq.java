package strings;

import java.util.ArrayList;
import java.util.List;

public class MaxLengthOfConcatSeq {
    private int maxLength=0;
    private boolean check(String a){
        int[] freq=new int[26];
        for(int i=0;i<a.length();i++){
            int index=a.charAt(i)-'a';
            if(freq[index]>0) return false;
            freq[index]++;
        }
        return true;
    }

    private void solve(List<String> res, List<String> nums, String s, int index){
        if(index>=nums.size()){
            res.add(s);
            return;
        }

        solve(res,nums,s+nums.get(index),index+1);
        solve(res,nums,s,index+1);
    }
    public int maxLength(List<String> nums) {
        int n=nums.size();
        List<String> res=new ArrayList<>();
        solve(res,nums,"",0);

        int maxLength=0;
        for(int i=0;i<res.size();i++){
            if(check(res.get(i))) maxLength=Math.max(maxLength,res.get(i).length());
        }
        return maxLength;
    }
}
