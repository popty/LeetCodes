class Solution {
    
    int[] difficulties;
    int N = 0;
    int[][] memo;
    
    private int helper(int ind, int d){
        
        if(ind == N && d == 0) return 0;
        if(d == 0 || ind == N) return Integer.MAX_VALUE;
        if(memo[ind][d] != -1) return memo[ind][d];
        
        int curr = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = ind; i<N; i++){
            curr = Math.max(curr, difficulties[i]);
            int temp = helper(i+1, d-1);
            if(temp != Integer.MAX_VALUE){
                min = Math.min(min, temp+curr);
            }
        }
        
        return memo[ind][d] = min;
        
    }
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.N = jobDifficulty.length;
        this.difficulties = jobDifficulty;
        if(d > N) return -1;
        this.memo = new int[N][d+1];
        
        for(int[] row: memo)Arrays.fill(row, -1);
        
        return helper(0, d);
        
    }
}