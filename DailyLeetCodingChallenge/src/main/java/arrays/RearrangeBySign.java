package arrays;

public class RearrangeBySign {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] pos=new int[n/2];
        int[] neg=new int[n/2];

        int l=0,r=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0) neg[l++]=nums[i];
            else pos[r++]=nums[i];
        }
        int[] res=new int[n];
        l=0;r=0;
        for(int i=0;i<n;i++){
            if(i%2==0) res[i]=pos[l++];
            else res[i]=neg[r++];
        }
        return res;
    }
}
