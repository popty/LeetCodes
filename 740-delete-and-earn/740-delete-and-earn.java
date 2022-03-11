class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> maxEarned = new HashMap<>();
        int max_val = 0;
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+num);
            max_val = Math.max(max_val, num);
        }
        
        for(int i = 1; i<=max_val; i++){
            int maxEarnedHere = Math.max(maxEarned.getOrDefault(i-1, 0), 
                                     maxEarned.getOrDefault(i-2, 0)+map.getOrDefault(i, 0));
            maxEarned.put(i, maxEarnedHere);
        }
        
        
        return maxEarned.get(max_val);
        
        
    }
}