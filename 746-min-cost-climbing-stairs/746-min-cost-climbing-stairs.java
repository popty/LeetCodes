class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCost = new int[n+1];
        minCost[0] = 0;
        minCost[1] = 0;
        
        for(int i = 2; i<=n; i++){
            minCost[i] = Math.min(minCost[i-2]+cost[i-2],
                                  minCost[i-1]+cost[i-1]);
        }
        
        return minCost[n];
    }
}