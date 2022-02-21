class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int max = 0;
        long actual_sum = 0;
        for(int num: nums){
            if(num > max) max = num;
            actual_sum+=num;
            
        }
        
        if(max == n-1)return n;
        
        long ideal_sum = n*(n-1)/2;
        
        if(ideal_sum == actual_sum) return n;
        
        actual_sum-=n;
        
        return (int)(ideal_sum-actual_sum);
    }
}