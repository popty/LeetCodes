class Solution {
    public String longestCommonPrefix(String[] strs) {
        
     //   if(strs.length == 1)return strs[0];
        
        int maxLen = Integer.MAX_VALUE;
        
        for(String str: strs){
            int len = str.length();
            if(maxLen > len) maxLen = len;
        }
        
        while(maxLen>0){
            int init = maxLen;
            String str = strs[0].substring(0, maxLen);
            for(int i = 1; i<strs.length; i++){
                if(!strs[i].substring(0, maxLen).equals(str)){
                    maxLen--;
                    break;
                }
            }
            
            if(init == maxLen) return str;
        }
        
        return "";
        
        
    }
}