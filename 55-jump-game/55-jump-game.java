class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
     //   boolean[] dp = new boolean[n];
        //dp[n-1] = true;
        int last_reachable = n-1;
        for(int i = n-2; i>=0; i--){
            if(i+nums[i]>= last_reachable){
                last_reachable = i;
            }
        }
        
        return last_reachable == 0;
    }
}