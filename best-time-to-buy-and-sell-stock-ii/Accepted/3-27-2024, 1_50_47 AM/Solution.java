// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int cur = prices[0];

        for(int i=1;i<n;i++){
            if(cur < prices[i]){
                profit+= prices[i]-cur;
            }
            cur = prices[i];
        }

        return profit;
    }
}