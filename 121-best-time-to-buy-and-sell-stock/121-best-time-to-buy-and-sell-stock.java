class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = Integer.MAX_VALUE;
        for(int price: prices){
            if(buy > price){
                buy = price;
            }
            else{
                maxProfit = Math.max(maxProfit, price-buy);
            }
        }
        
        return maxProfit;
        
    }
}