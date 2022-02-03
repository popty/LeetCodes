class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i<strs.length; i++){
            String str = strs[i];
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortStr =  String.valueOf(strArray);
            
            if(map.containsKey(sortStr)){
                List<String> list = map.get(sortStr);
                list.add(strs[i]);
                map.put(sortStr, list);
            }else{
                List<String> list = new ArrayList();
                list.add(strs[i]);
                map.put(sortStr, list);
            }
        }
        
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}