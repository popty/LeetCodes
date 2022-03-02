import java.util.stream.*;

class Solution {
    
    private String sortChars(String str){
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> list = new ArrayList<>();
        
       Map<String, List<String>> map =
       Arrays.stream(strs).collect(Collectors.groupingBy(w -> sortChars(w)));
        
        for(List<String> tempList : map.values()){
            list.add(tempList);
        }
        
        return list;
    }
}