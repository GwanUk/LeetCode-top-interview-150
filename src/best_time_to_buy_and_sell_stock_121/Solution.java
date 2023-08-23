package best_time_to_buy_and_sell_stock_121;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            int profit = price - minPrice;

            maxProfit = Math.max(maxProfit, profit);

            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }
}