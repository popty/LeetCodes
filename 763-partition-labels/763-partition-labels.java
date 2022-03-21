class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }
        
        List<Integer> result = new ArrayList<>();
        int j = 0, anchor = 0;
        for(int i = 0; i<s.length(); i++){
            j = Math.max(j, map.get(s.charAt(i)));
            if(i == j){
                result.add(i-anchor+1);
                anchor = i+1;
            }
        }
        return result;
    }
}