class Solution {
    
    private void swap(int[] nums, int i, int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private int partition(int[] nums, int start, int end){
        int i = start+1;
        int pivot = nums[start];
        for(int j = start+1; j<=end; j++){
            if(nums[j] < pivot){
                swap(nums, j, i);
                i+=1;
            }
        }
        
        swap(nums, start, i-1);
        return i-1;
    }
    
    private void quicksort(int[] nums, int start, int end){
        if(start < end){
            int pivot_ind = partition(nums, start, end);
            quicksort(nums, start, pivot_ind-1);
            quicksort(nums, pivot_ind+1, end);
        }
    }
    
    public void sortColors(int[] nums) {
        quicksort(nums, 0, nums.length-1);
    }
}