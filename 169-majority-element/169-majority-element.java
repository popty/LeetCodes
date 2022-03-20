class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 1;
        int majority = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            int num = nums[i];
            
            if(num != majority)count--;
            
            if(count == 0){
                majority = num;
            }
            
           if(num == majority){
                count++;
            }
          
        }
        
        return majority;
    }
}