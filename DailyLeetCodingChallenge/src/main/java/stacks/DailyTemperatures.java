package stacks;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        Arrays.fill(res,0);
        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]) st.pop();

            if(!st.isEmpty() && nums[st.peek()]>nums[i]) res[i]=st.peek()-i;
            st.push(i);
        }
        return res;
    }
}
