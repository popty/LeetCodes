class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        vector<int> map(128, -1);
        int start = 0;
        int maxLen = 0;
        for(int i = 0; i<s.size(); i++){
            if(map[s[i]] != -1){
                start = max(start, map[s[i]]+1);
            }
            map[s[i]] = i;
            maxLen = max(maxLen, i-start+1);
        }
        
        return maxLen;
    }
};