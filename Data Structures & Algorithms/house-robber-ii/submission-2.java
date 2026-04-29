class Solution {

    int ans(int i,int n,int[] nums,int[] dp){
        
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];

        int take = nums[i] + ans(i+2,n,nums,dp);
        int skip = ans(i+1,n,nums,dp);

        dp[i] = Math.max(take,skip);
        return dp[i];
    }


    public int rob(int[] nums) {
         int n = nums.length;
         if(n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        int[] arr1 = new int[n-1]; for(int i=0;i<n-1;i++) arr1[i] = nums[i];
        int[] arr2 = new int[n-1]; for(int i=0;i<n-1;i++) arr2[i] = nums[i+1];

        int ans1 = ans(0,n-1,arr1,dp1);
        int ans2 = ans(0,n-1,arr2,dp2);
        return Math.max(ans1,ans2);

        // return Math.max(ans1,ans2);
    }
}
