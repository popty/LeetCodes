class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int curr_max = 0;
        for(int num: nums){
            curr_max+=num;
            if(ans < curr_max){
                ans = curr_max;
            }
            
            if(curr_max < 0){
                curr_max = 0;
            }
        }
        return ans;
    }
}