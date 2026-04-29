class Solution {
    int ans = 0;
    int answ(int i,int n,int[] cost,int[] dp){
        if(i >= n) return 0;

        if(dp[i] != -1) return dp[i];
         dp[i] = cost[i] + Math.min(answ(i+1,n,cost,dp),answ(i+2,n,cost,dp));

         return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {

         int n = cost.length;
         int[] dp = new int[n+1];
        for(int i=0;i<=n;i++) dp[i] = -1;

        return Math.min(answ(0,n,cost,dp),answ(1,n,cost,dp));
    }
}