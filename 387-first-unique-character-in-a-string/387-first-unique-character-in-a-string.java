class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        Arrays.fill(map, 0);
        for(int i = 0; i<s.length(); i++){
            char c= s.charAt(i);
            map[c-'a']++;
        }
        
        for(int i = 0; i<s.length(); i++){
             char c= s.charAt(i);
            if(map[c-'a'] == 1) return i;
        }
        
        return -1;
    }
}