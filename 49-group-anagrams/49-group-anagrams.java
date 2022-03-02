class Solution {
    
    private String sortChar(String str){
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = 
            Arrays.stream(strs).collect(Collectors.groupingBy(w ->sortChar(w)));
        
        return new ArrayList<>(map.values());
    }
}