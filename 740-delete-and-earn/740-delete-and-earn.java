class Solution {
    public int deleteAndEarn(int[] nums) {
            int[] buckets = new int[10001];
            int max = 0;
            for (int num : nums) {
                buckets[num] += num;
                max = Math.max(max, num);
            }
            int[] dp = new int[10001];
            dp[0] = buckets[0];
            dp[1] = buckets[1];
            for (int i = 2; i <=max; i++) {
                dp[i] = Math.max(buckets[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[max];
        }
}