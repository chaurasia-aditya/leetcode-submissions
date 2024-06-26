// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0, j;
        
        for(int i=n-1;i>=0;){
            while(i>=1 && prices[i]<=prices[i-1]){
                i--;
            }
            j = i-1;
            while(j>=0 && prices[j]<prices[j+1]){
                j--;
            }
            res+=prices[i]-prices[j+1];
            i=j;
        }

        return res;
    }
}