class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int longest = 1;
        for(int i = 1; i<nums.length; i++){
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i])
                    dp[i]  = Math.max(dp[i], dp[j]+1);
                    longest = Math.max(dp[i], longest);
            }
        }
        
        return longest;
        
    }
}