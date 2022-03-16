class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] bucket = new int[10001];
        int max = 0;
        
        if(nums.length == 1) return nums[0];
        
        for(int num: nums){
            bucket[num]+=num;
            max = Math.max(max, num);
        }
        
        int[] dp = new int[max+1];
        dp[1] = bucket[1];
        for(int i = 2; i<=max; i++){
            dp[i] = Math.max(bucket[i]+dp[i-2], dp[i-1]);
        }
        
        return dp[max];
    }
}