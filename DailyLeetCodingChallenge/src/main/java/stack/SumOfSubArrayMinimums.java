package stack;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubArrayMinimums {
    private static final int limit=(int)(Math.pow(10,9)+7);
    private static int[] nextSmallerRight(int[] nums){
        int n=nums.length;
        int[] res=new int[n];
        Arrays.fill(res,n);

        Stack<Integer> stack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int v=nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]>=v) stack.pop();

            if(!stack.isEmpty()) res[i]=stack.peek();
            stack.push(i);
        }
        return res;
    }

    private static int[] nextSmallerLeft(int[] nums){
        int n=nums.length;
        int[] res=new int[n];
        Arrays.fill(res,-1);

        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            int v=nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]>v) stack.pop();

            if(!stack.isEmpty()) res[i]=stack.peek();
            stack.push(i);
        }
        return res;
    }

    public static int sumSubarrayMins(int[] arr) {
        int n=arr.length;

        int[] nextSmallerLeft=nextSmallerLeft(arr);
        int[] nextSmallerRight=nextSmallerRight(arr);

        for(int i=0;i<n;i++) System.out.print(nextSmallerLeft[i]+" ");
        System.out.println();
        for(int i=0;i<n;i++) System.out.print(nextSmallerRight[i]+" ");

        long sum=0;
        for(int i=0;i<n;i++){
            long count=((i-nextSmallerLeft[i])*(nextSmallerRight[i]-i))% limit;
            long totalValue=((arr[i]%limit)*(count%limit))%limit;
            sum=(sum%limit+totalValue%limit)%limit ;
        }

        return (int)sum;
    }

    public static void main(String[] args) {
        int[] nums={71,55,82,55};
        System.out.println();
        System.out.println(sumSubarrayMins(nums));
    }
}
