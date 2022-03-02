class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> list = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i<strs.length; i++){
             char[] str = strs[i].toCharArray();
             Arrays.sort(str);
             String temp = new String(str);
             List<String> tempList = map.getOrDefault(temp, new ArrayList<String>());
             tempList.add(strs[i]);
             map.put(temp, tempList);
        }
        
        for(List<String> tempList : map.values()){
            list.add(tempList);
        }
        
        return list;
    }
}