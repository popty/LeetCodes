class Solution {
    
    private int coinChange(int[] coins, int amount, int[] count){
        if(amount < 0) return -1;
        
        if(amount == 0) return 0;
        
        if(count[amount]!=0)return count[amount];
        
        int min = Integer.MAX_VALUE;
        for(int coin: coins){
            int res = coinChange(coins, amount-coin, count);
            if(res >= 0 && res < min){
                min = 1+res;
            }
        }
        
        count[amount] = min == Integer.MAX_VALUE ? -1 : min;
            
        return count[amount];
    }
    
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        return coinChange(coins, amount, new int[amount+1]);
    }
}