// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int i,j, max = 0;
        for(i=0;i<prices.length;){
            for(j=i+1;j<prices.length;j++){
                if(prices[j]<prices[i])
                    break;
                max = Math.max(max, prices[j] - prices[i]);
            }
            i=j;
        }
        return max;
    }
}