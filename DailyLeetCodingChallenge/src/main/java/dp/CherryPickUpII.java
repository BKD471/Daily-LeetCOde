package dp;

import java.util.Arrays;

public class CherryPickUpII {
    private int solve(int[][] grid,int i,int j1,int j2,int m,int n,int[][][] memo){
        if(j1<0 || j1>=n || j2>=n || j2<0) return -(int)(Math.pow(10,8));

        if(i==m-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if(memo[i][j1][j2]!=-1) return memo[i][j1][j2];

        int maxV=Integer.MIN_VALUE;
        for(int a=-1;a<=1;a++){
            for(int b=-1;b<=1;b++){
                if(j1==j2) maxV=Math.max(maxV,grid[i][j2]+solve(grid,i+1,j1+a,j2+b,m,n,memo));
                else maxV=Math.max(maxV,grid[i][j1]+grid[i][j2]+solve(grid,i+1,j1+a,j2+b,m,n,memo));
            }
        }
        memo[i][j1][j2]=maxV;
        return maxV;
    }
    public int cherryPickup(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][][] memo=new int[m+1][n+1][n+1];
        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) Arrays.fill(memo[i][j],-1);
        }
        return solve(grid,0,0,n-1,m,n,memo);
    }
}
