class Solution {
    int[] nums;
    int size;
    
    private void swap(int a, int b){
        int temp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = temp;
        
        return;
    }
    
    private int partition(int start, int end){
        int pivot = nums[start];
        int i = start+1;
        for(int j = start+1; j<=end; j++){
            if(nums[j] < pivot){
                swap(i, j);
                i+=1;
            }
        }
        
        swap(start, i-1);
        
        return i-1;
    }
    
    
    public int quickselect(int start, int end, int targ_ind){
        if(start == end) return nums[start];
        
        int pivot_index = partition(start, end);
        
        if(targ_ind == pivot_index) return nums[pivot_index];
        
        else if(targ_ind < pivot_index) return quickselect(start, pivot_index-1, targ_ind); 
        
        else return quickselect(pivot_index+1, end, targ_ind);
        
        
    }
    
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        this.size = nums.length;
        return quickselect(0, size-1, size-k);
    }
}