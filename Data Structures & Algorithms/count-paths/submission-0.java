class Solution {
    public int totalPath(int[][] dp,int i,int j, int m, int n) {
        if(i == m-1 && j == n-1) return 1;
        if(i > m-1 || j > n-1 || i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        
        dp[i][j] = totalPath(dp,i+1,j,m,n) + totalPath(dp,i,j+1,m,n);
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++) dp[i][j] = -1;
        }
        return totalPath(dp,0,0,m,n);
    }
}
