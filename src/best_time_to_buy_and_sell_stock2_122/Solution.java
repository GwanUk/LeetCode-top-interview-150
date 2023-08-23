package best_time_to_buy_and_sell_stock2_122;

class Solution {
    public int maxProfit(int[] prices) {
        int accumulation = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0)
                accumulation += profit;
        }

        return accumulation;
    }
}