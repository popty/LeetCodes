class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);   
    }
    
    private boolean wordBreakHelper(String s, Set<String> wordDict, int start, Boolean[] memo){
        if(start == s.length()) return true;
        
        if(memo[start] != null) return memo[start];
        
        for(int i = start+1; i<=s.length(); i++){
            if(wordDict.contains(s.substring(start, i)) &&
               wordBreakHelper(s, wordDict, i, memo)){
                memo[start] = true;
                return true;
            }
        }
        
        return memo[start] = false;
    }
}