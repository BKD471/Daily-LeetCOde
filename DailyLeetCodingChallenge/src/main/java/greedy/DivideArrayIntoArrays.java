package greedy;

import java.util.Arrays;

public class DivideArrayIntoArrays {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;

        if(n%3!=0) return new int[][]{};


        int[][] res=new int[n/3][3];
        Arrays.sort(nums);

        int index=0;
        for(int i=0;i<n;i+=3){
            if(i+2<n && nums[i+2]-nums[i]<=k){
                int[] temp=new int[]{nums[i],nums[i+1],nums[i+2]};
                res[index++]=temp;
            }else{
                return new int[][]{};
            }
        }
        return res;
    }
}
