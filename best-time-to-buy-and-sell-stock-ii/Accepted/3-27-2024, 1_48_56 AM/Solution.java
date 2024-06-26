// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if(n<=1)
            return 0;

        int profit = 0;
        int cur = prices[0];

        for(int i=1;i<n;i++){
            // System.out.println("i = "+ i +" cur = "+cur+" profit = "+profit);
            if(prices[i]<prices[i-1]){
                profit+= prices[i-1]-cur;
                cur = prices[i];
            }
        }

        if(prices[n-1]>=prices[n-2])
            profit+=prices[n-1]-cur;

        return profit;
    }
}