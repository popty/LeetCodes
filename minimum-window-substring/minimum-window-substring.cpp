class Solution {
public:
    string minWindow(string s, string t) {
        vector<int> map(128, 0);
        for(char c: t){
            map[c]++;
        }
        
        int counter = t.size(), begin = 0, end = 0, head = 0, len = INT_MAX;
        
        while(end < s.length()){
            if(map[s[end++]]-->0)counter--;
            
            while(counter==0){
                if(len > end - begin) len = end - (head=begin);
                if(map[s[begin++]]++==0)counter++;
            }
        }
        
        return len==INT_MAX?"":s.substr(head, len);
    }
};