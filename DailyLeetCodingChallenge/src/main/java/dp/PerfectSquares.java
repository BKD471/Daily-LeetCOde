package dp;

import java.util.Arrays;

public class PerfectSquares {
    private static final int LIMIT=(int)(Math.pow(10,8));
    private int solve(int num,int[] memo){
        if(num==0) return 0;
        if(memo[num]!=-1) return memo[num];

        int min_take=LIMIT;
        for(int i=1;i<num;i++){
            int sq=i*i,take=LIMIT;
            if(num>=sq) take=1+solve(num-sq,memo);
            min_take=Math.min(min_take,take);
        }
        return memo[num]=min_take;
    }
    public int numSquares(int n) {
        if(n<=3) return n;
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        return solve(n,memo);
    }
}
