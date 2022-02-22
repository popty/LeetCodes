class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstringUtil(s, 0, s.length(), k);
    }
    
    private int longestSubstringUtil(String s, int start, int end, int k){
        if(end < k)return 0;
        
        int[] countMap = new int[26];
        
      for (int i = start; i < end; i++)
            countMap[s.charAt(i) - 'a']++;
        
        for(int mid = start; mid<end; mid++){
            char c = s.charAt(mid);
            if(countMap[c-'a']>=k)continue;
            int midNext = mid+1;
           // char temp = s.charAt(midNext);
            while(midNext < end && countMap[s.charAt(midNext)-'a'] < k)midNext++;
            
            return Math.max(longestSubstringUtil(s, start, mid, k), longestSubstringUtil(s, midNext, end, k));
            
        }
        return (end-start);
    }
}