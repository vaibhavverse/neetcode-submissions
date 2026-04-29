class Solution {
     boolean isPalin(String s,int i,int j){

        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
      }
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";  
        int length = 0;
        int prevLength = length;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalin(s,i,j)){
                    length = Math.max(length,j-i+1);
                    if(length > prevLength){ ans = s.substring(i,j+1); prevLength = length;
                    }
                }
            }
        }
        return ans;
    }
}