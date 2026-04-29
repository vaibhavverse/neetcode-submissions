class Solution {
    int isPalin(String s,int start,int end){

        if(start >= end) return 1;
        if(s.charAt(start) == s.charAt(end)) return isPalin(s,start+1,end-1);

        return 0;
    }
    public int countSubstrings(String s) {

       int n = s.length();
       int count = 0;

       for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            if(isPalin(s,i,j) == 1){
                count++;
            }
        }
       } 
       return count;
    }
}
