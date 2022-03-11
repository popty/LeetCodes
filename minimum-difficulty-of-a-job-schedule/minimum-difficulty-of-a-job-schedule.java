class Solution {
    int N = 0;
    int[][] memo;
    int[] difficulties;
    
    private int helper(int ind, int d){
      
        if(ind == N && d == 0) return 0;
        
        if(ind == N || d == 0) return Integer.MAX_VALUE;
        
        if(memo[ind][d] != -1) return memo[ind][d];
        
        int min = Integer.MAX_VALUE;
        int curr = difficulties[ind];
        for(int schedule = ind; schedule < N; schedule++){
            curr = Math.max(difficulties[schedule], curr);
            int temp =  helper(schedule+1, d-1);
            if(temp != Integer.MAX_VALUE){
                min = Math.min(min, temp+curr);
            }
        }
        
        return memo[ind][d] = min;
        
    }
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.N = jobDifficulty.length;
        this.difficulties = jobDifficulty;
        if(N < d) return -1;
        memo = new int[N][d+1];
        
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        
        return helper(0, d);
        
    }
    
    
    
}