class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            if(map.containsKey(target - num)){
                res[0] = map.get(target-num);
                res[1] = i;
            }
            map.put(num, i);
        }
        
        return res;
    }
}