class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while(fast < nums.length){
            while(fast < nums.length && nums[fast] == nums[slow]){
                fast++;
            }
            if(fast == nums.length) break;
            
            slow++;
            nums[slow] = nums[fast];
            fast++;
        }
        return slow+1;
            
    }
}