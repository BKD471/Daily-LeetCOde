package dp;

import java.util.Arrays;

public class OutOfBoundaryWallsLC576 {
    private static final long limit=(long)(Math.pow(10,9)+7);

    private long solve(int row,int col,int m,int n,long[][][] memo,int move){
        if(row<0 || row>=m || col<0 || col>=n) return 1;
        if(move<=0) return 0;
        if(memo[row][col][move]!=-1) return memo[row][col][move];

        long res=0;
        res+=solve(row+1,col,m,n,memo,move-1);
        res+=solve(row-1,col,m,n,memo,move-1);
        res+=solve(row,col-1,m,n,memo,move-1);
        res+=solve(row,col+1,m,n,memo,move-1);

        return memo[row][col][move]=res%limit;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] memo=new long[m][n][maxMove+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        return (int)solve(startRow,startColumn,m,n,memo,maxMove);
    }
}
