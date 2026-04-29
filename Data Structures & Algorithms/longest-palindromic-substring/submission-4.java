class Solution {
     int isPalin(int[][] dp, String s,int i,int j){

        if(i >= j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) return dp[i][j] = isPalin(dp,s,i+1,j-1);

        return 0;
      }
    public String longestPalindrome(String s) {

        int n = s.length();
        String ans = "";  
        int maxLen = Integer.MIN_VALUE;
        int idx = 0;

       int[][] dp = new int[n][n];
       for(int i=0;i<n; i++){
        for(int j=0;j<n;j++) dp[i][j] = -1;
       }

       for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            if(isPalin(dp,s,i,j) == 1){
                if(j - i + 1 > maxLen){
                  maxLen = j-i+1;
                  idx = i;
                }
            }
        }
       }
        return s.substring(idx, idx + maxLen);
    }
}