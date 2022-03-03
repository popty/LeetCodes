class Solution {
    public int strStr(String haystack, String needle) {
        
        int m = haystack.length(), n = needle.length();
        if(n == 0) return 0;
        
        int[] lps = helper(needle);
        
        for(int i = 0, j = 0; i<m;){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            
            if(j == n){
                return i-j;
            }
            
            if(i < m && haystack.charAt(i) != needle.charAt(j)){
                if(j == 0) 
                    i++;
                else
                     j = lps[j-1];
            }
        }
        
        return -1;
    }
    
    private int[] helper(String needle){
        int n = needle.length();
        int[] lps = new int[n];
        for(int i = 1, len = 0; i<n; ){
            if(needle.charAt(i) == needle.charAt(len)){
                lps[i++] = ++len;
            }else if(len != 0){
                len = lps[len-1];
            }else{
                lps[i++] = 0;
            }
        }
        
        return lps;
    }
}