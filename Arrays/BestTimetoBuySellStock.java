/*

121. Best Time to Buy and Sell Stock
Easy

17957

580

Add to List

Share
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

*/


class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i = 0; i < prices.length ; i++){
            if(prices[i] < minSoFar) {
                minSoFar = prices[i];
            }
            else {
                maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            }
        }
        
        return maxProfit;
    }
}