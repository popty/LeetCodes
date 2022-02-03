class Solution {
public:
    string minWindow(string s, string t) {
        vector<int> map(128,0);
        for(auto c: t){
            map[c]++;
        }
        
        int begin = 0, end = 0, len = INT_MAX, head=0;
        int count = t.size();
        while(end < s.size()){
            if(map[s[end++]]-->0)count--;
            
            while(count==0){
                if(len > end - begin) len = end - (head=begin);
                if(map[s[begin++]]++==0)count++;
            }
        }
        
        return len==INT_MAX?"":s.substr(head, len);
        
    }
};