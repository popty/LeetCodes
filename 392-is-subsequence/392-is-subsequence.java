class Solution {
    public boolean isSubsequence(String s, String t) {
        
        HashMap<Character, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i<t.length(); i++){
            List<Integer> temp = map.getOrDefault(t.charAt(i), new ArrayList<>());
            temp.add(i);
            map.put(t.charAt(i), temp);
        }
        
        
        Integer current = -1;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c))return false;
            
            boolean isMatch = false;
            
            for(Integer index :  map.get(c)){
                if(current < index){
                    current = index;
                    isMatch = true;
                    break;
                }
            }
               
             if(!isMatch) return false;
            
        }
        
        return true;
        
    }
}