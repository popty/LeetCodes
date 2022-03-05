class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, Integer> cache = new HashMap<>();
    
    
    private int helper(int num){
        if(num == 0) return 0;
        
        if(num == 1){
            return map.getOrDefault(num, 0);
        }
        
        if(cache.containsKey(num)){
            return cache.get(num);
        }
        
        int gain = map.getOrDefault(num, 0);
        cache.put(num, Math.max(helper(num-1), gain+helper(num-2)));
        return cache.get(num);
    }
    
    public int deleteAndEarn(int[] nums) {
        
        int maxNumber = 0;
        for(int num: nums){
            maxNumber = Math.max(num, maxNumber);
            int sumSoFar = map.getOrDefault(num, 0);
            sumSoFar+=num;
            map.put(num, sumSoFar);
        }
        
        cache.put(0, 0);
        cache.put(1, map.getOrDefault(1, 0));
        for(int i = 2; i<=maxNumber; i++){
            int gain = map.getOrDefault(i, 0);
            cache.put(i, Math.max(cache.get(i-1), gain+cache.get(i-2)));
        }
        
        return cache.get(maxNumber);
        
    }
}