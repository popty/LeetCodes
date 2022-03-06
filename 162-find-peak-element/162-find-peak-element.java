class Solution {
    
    private int binary(int[] nums, int start, int end){
        if(start == end) return start;
        
        int mid = start + (end-start)/2;
        
        if(nums[mid] > nums[mid+1])
            return binary(nums, start, mid);            return binary(nums, mid+1, end);
    }
    
    public int findPeakElement(int[] nums) {
        return binary(nums, 0, nums.length-1);
    }
}