class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for(int p: prices){
            if(p < buy){
                buy = p;
            }else if(p > buy){
                profit = Math.max(profit, p-buy);
            }
        }
        
        return profit;
    }
}