package dp;

import java.util.Arrays;

public class LongestCommonSubsequnce {
    private int lcs(String s,String t,int i,int j,int[][] memo){
        if(i>=s.length() || j>=t.length()) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return memo[i][j]=1+lcs(s,t,i+1,j+1,memo);
        } else{
            return memo[i][j]=Math.max(lcs(s,t,i,j+1,memo),
                    lcs(s,t,i+1,j,memo));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(),n=text2.length();
        int[][] memo=new int[m+1][n+1];
        for(int i=0;i<m;i++) Arrays.fill(memo[i],-1);
        return lcs(text1,text2,0,0,memo);
    }
}
