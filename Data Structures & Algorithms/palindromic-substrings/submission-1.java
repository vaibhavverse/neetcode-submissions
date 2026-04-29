class Solution {
    int isPalin(int[][] dp, String s,int start,int end){

        if(start >= end) return 1;
        if(dp[start][end] != -1) return dp[start][end];
        if(s.charAt(start) == s.charAt(end)) return dp[start][end] = isPalin(dp,s,start+1,end-1);

        return dp[start][end] = 0;
    }
    public int countSubstrings(String s) {

       int n = s.length();
       int count = 0;
       int[][] dp = new int[n][n];

       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++) dp[i][j] = -1;
       }

       for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            if(isPalin(dp,s,i,j) == 1){
                count++;
            }
        }
       } 
       return count;
    }
}
