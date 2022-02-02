class Solution {
    public void nextPermutation(int[] nums) {
        
        int i = nums.length - 2;
       
        while(i>=0 && nums[i+1] <= nums[i]){
            i--;
        }
        
        int j = nums.length - 1;
        if(i>=0){
            while(nums[j]<=nums[i]){
                j--;
            }
            
            swap(nums, i, j);
        }
        
        reverse(nums, i+1);
    }
    
    
    private void reverse(int[] nums, int start){
        int end = nums.length-1;
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}