class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0, sum = 0;
        if(nums.length < 3) return 0;
        for(int i = 2; i<nums.length; i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2])count++;
            else
                count = 0;
            sum+=count;
        }
        
        return sum;
    }
}