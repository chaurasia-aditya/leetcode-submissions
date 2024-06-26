// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] minarr = new int[n];
        int[] maxarr = new int[n];
        int res = Integer.MIN_VALUE;

        minarr[0] = prices[0];
        maxarr[n-1] = prices[n-1];
        
        for(int i=1;i<n;i++){
            minarr[i] = Math.min(prices[i],minarr[i-1]);
            maxarr[n-1-i] = Math.max(prices[n-i], maxarr[n-i]);
        }

        for(int i=0;i<n;i++){
            res = Math.max(res, maxarr[i]-minarr[i]);
        }
        res = Math.max(res,0);
        return res;
    }
}