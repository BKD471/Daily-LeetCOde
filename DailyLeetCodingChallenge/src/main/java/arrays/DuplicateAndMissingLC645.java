package arrays;

public class DuplicateAndMissingLC645 {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int duplicate=-1,missing=-1;
        for(int i=0;i<n;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[index]<0){
                duplicate=index+1;
                continue;
            }
            nums[index]=-nums[index];
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                missing=i+1;
                continue;
            }
            nums[i]=-nums[i];
        }
        return new int[]{duplicate,missing};
    }
}
