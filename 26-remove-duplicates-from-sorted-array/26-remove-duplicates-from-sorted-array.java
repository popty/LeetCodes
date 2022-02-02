class Solution {
    public int removeDuplicates(int[] nums) {
       
        int slow = 0, fast = 0;
        
        while(fast < nums.length && slow < nums.length-1){
            
            while(fast < nums.length && nums[slow] == nums[fast])fast++;
            
            if(fast == nums.length) break;
            
            nums[slow+1] = nums[fast];
            slow++;
            fast++;
        }
        
        return slow+1;
        
    }
}