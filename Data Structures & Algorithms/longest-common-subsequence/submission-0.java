class Solution {
    public int lcs(int[][] dp, String s1, String s2,int n,int m) {

        if(n == 0 || m == 0) return 0;
        // if()
        if(dp[n][m] != -1) return dp[n][m];

        if(s1.charAt(n-1) == s2.charAt(m-1)) return dp[n][m] = 1 + lcs(dp,s1,s2,n-1,m-1);

        return dp[n][m] = Math.max(lcs(dp,s1,s2,n-1,m), lcs(dp,s1,s2,n,m-1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++) dp[i][j] = -1;
        }

        return lcs(dp,text1,text2,n,m);
    }
}
