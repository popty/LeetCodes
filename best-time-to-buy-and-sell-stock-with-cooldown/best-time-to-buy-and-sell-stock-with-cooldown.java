class Solution {
    
    int[] prices;
    int[][][] memo;
    
    
    private int helper(int index, int holding, int cooldown){
        if(index == prices.length)return 0;
        
        if(memo[index][holding][cooldown] == 0){
            int doNothing = helper(index+1, holding, 0);   
            int doSomething =0;
            if(holding == 1){
                doSomething = prices[index]+helper(index+1, 0, 1);
            }
            else if(holding == 0 && cooldown == 0){
                doSomething = -prices[index]+helper(index+1, 1, 0);
            }
            
            memo[index][holding][cooldown] = Math.max(doNothing, doSomething);
        }
        
        return memo[index][holding][cooldown];
    }
        
    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.memo = new int[prices.length][2][2];
        return helper(0, 0, 0);
    }
}