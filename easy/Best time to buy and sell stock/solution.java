class Solution {
    public int maxProfit(int[] prices) {
        int sell = Integer.MAX_VALUE;
        int profit=0;
        
        for(int i=0;i<prices.length;i++){
            if(prices[i]<sell){sell=prices[i];}
            else if(prices[i]-sell>profit){
                profit=prices[i]-sell;
            }
        }
        return profit;
    }
}