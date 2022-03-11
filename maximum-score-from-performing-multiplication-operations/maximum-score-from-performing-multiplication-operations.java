class Solution {
    
    int[] nums;
    int[] multipliers;
    int m, n;
    int[][] memo;
    
    public int helper(int i, int left){
        if(i == m)return 0;
        
        int right = n-1-(i-left);
        int mult = multipliers[i];
        
        if(memo[i][left] == 0){
            memo[i][left] = Math.max(mult*nums[left]+helper(i+1, left+1),
                                    mult*nums[right]+helper(i+1, left));
        }
        
        return memo[i][left];
    }
    
    public int maximumScore(int[] nums, int[] multipliers) {
          this.nums = nums;
          this.multipliers = multipliers;
          this.m = multipliers.length;
          this.n = nums.length;
          this.memo= new int[m][m];
          return helper(0, 0);
    }
}