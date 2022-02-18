class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        
        if(needle.equals("")) return 0;
        
        int n = needle.length();
        
        int index = -1;
        for(int i = 0; i<haystack.length()-n+1; i++){
            int k = i;
            int j;
            for(j = 0; j<n; j++){
               if(j == 0)index = i;
                if(haystack.charAt(k) != needle.charAt(j)){
                    break;
                }
                k++;
            }
            if(j == n) return index;
        }
        
        return -1;
    }
}