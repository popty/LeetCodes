class Solution {
    public void nextPermutation(int[] nums) {
        int first_decreasing = -1;
        for(int i = nums.length-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                first_decreasing = i;
                break;
            }
        }
        
        if(first_decreasing == -1){
            reverse(nums, 0);
            return;
        }
        
        for(int i = nums.length-1; i>=first_decreasing; i--){
            if(nums[i]>nums[first_decreasing]){
                int temp = nums[i];
                nums[i] = nums[first_decreasing];
                nums[first_decreasing] = temp;
                break;
            }
        }
        
        reverse(nums, first_decreasing+1);
    }
    
    
    private void reverse(int[] nums, int start){
        int end = nums.length-1;
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}