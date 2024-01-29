package dp;

public class MInFallingPathSUm {
    private static final int LIMIT=(int)(Math.pow(10,7));
    private int solve(int[][] matrix,int row,int col,int m,int n,Integer[][] memo){
        if(row<0 || row>=m || col<0 || col>=n) return LIMIT;
        if(row==m-1) return matrix[row][col];

        if(memo[row][col]!=null) return memo[row][col];
        int take1=matrix[row][col]+solve(matrix,row+1,col-1,m,n,memo);
        int take2=matrix[row][col]+solve(matrix,row+1,col,m,n,memo);
        int take3=matrix[row][col]+solve(matrix,row+1,col+1,m,n,memo);

        return memo[row][col]=Math.min(take3,Math.min(take2,take1));
    }
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int minV=Integer.MAX_VALUE;
        Integer[][] memo=new Integer[m][n];
        for(int i=0;i<n;i++) minV=Math.min(minV,solve(matrix,0,i,m,n,memo));
        return minV;
    }
}
