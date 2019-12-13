class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        if (prices.length == 2) {
            if (prices[1] < prices[0]) {
                return 0;
            } else {
                return prices[1] - prices[0];
            }
        }
        
        int[] profits = new int[prices.length - 1];
        for(int i = 1; i < prices.length; i++) {
            profits[i - 1] = prices[i] - prices[i - 1];
        }
        int[] dp = new int[prices.length - 1];
        dp[0] = profits[0];
        for (int i = 1; i < profits.length; i++) {
            dp[i] = dp[i - 1] < 0 ? profits[i] : profits[i] + dp[i - 1];
        }
        int ans = 0;
        for (int i: dp) {
            if (i > ans) {
                ans = i;
            }
        }
        return ans;
    }
}