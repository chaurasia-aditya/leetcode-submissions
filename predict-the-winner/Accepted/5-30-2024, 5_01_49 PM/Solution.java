// https://leetcode.com/problems/predict-the-winner

class Solution {
    int getMax(int st, int end, int[] nums, int[][] dp){
        if(st==end)
            return nums[st];
        
        if(dp[st][end]!=-1)
            return dp[st][end];

        int takeFirst = nums[st] - getMax(st+1, end, nums, dp);
        int takeLast = nums[end] - getMax(st, end-1, nums, dp);

        return dp[st][end] = Math.max(takeFirst, takeLast);
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for(int[] i: dp)
            Arrays.fill(i, -1);

        for(int i=0;i<n;i++){
            dp[i][i] = nums[i];
        }

        return getMax(0, n-1, nums, dp)>=0;
    }
}