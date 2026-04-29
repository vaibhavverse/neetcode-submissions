class Solution {
    int findPath(int n,int[] dp){

        if(n == 1) return 1;
        if(n == 2) return 2;
        if(dp[n] != -1) return dp[n];

        return dp[n] = findPath(n-1,dp) + findPath(n-2,dp);
        
    }
    public int climbStairs(int n) {
        // if(n == 1) return 1;
        // if(n == 2) return 2;
        // return climbStairs(n-1) + climbStairs(n-2);

        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++) dp[i] = -1;

        return findPath(n,dp);
    }
}
