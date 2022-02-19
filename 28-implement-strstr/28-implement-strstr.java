class Solution {
    int[] lps;
    
    public int strStr(String haystack, String needle) {
        
        int m = haystack.length();
        int n = needle.length();
        
        if(needle.length() == 0) return 0;
        
        if(m < n) return -1;
        
        preprocessor(needle, n);
        
        for(int i = 0, j = 0; i<m; ){
            if(haystack.charAt(i)== needle.charAt(j)){
                i++;
                j++;
            }
            
            if(j == n) return i-j;
        
            if(i<m && haystack.charAt(i)!= needle.charAt(j)){
                if(j == 0)i++;
                else{
                    j = lps[j-1];
                }
            }
            
        }
        
        return -1;
        
    }
    
    private void preprocessor(String t, int n){
        this.lps = new int[n];
        int len = 0;
        for(int i = 1; i<n;){
            if(t.charAt(i) == t.charAt(len)){
               lps[i++] = ++len;
            }
            else if(len > 0)
                len = lps[len-1];
            else
                lps[i++]  = 0;
        }
        
        return;
    }
    
    
}