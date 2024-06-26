// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int cur = prices[0];
        
        for(int i=1;i<prices.length;i++){
            if(prices[i]>=cur){
                res = Math.max(res, prices[i]-cur);
            }else{
                cur = prices[i];
            }
        }
        
        return res;
    }
}