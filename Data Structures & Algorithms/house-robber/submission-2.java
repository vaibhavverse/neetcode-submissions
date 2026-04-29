class Solution {
    int ans(int i,int[] nums,int[] dp){

        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];

       int take = nums[i] + ans(i+2,nums,dp);
       int skip = ans(i+1,nums,dp);

       dp[i] = Math.max(take,skip);
       return dp[i];

    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return Math.max(ans(0,nums,dp),ans(1,nums,dp));
    }
}
