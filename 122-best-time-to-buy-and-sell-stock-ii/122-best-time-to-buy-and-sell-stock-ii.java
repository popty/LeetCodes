class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        for(int price: prices){
            if(price > buy){
              profit = profit + price - buy;
            }
            buy = price;
        }
        return profit;
    }
}