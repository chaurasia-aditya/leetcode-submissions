// https://leetcode.com/problems/predict-the-winner

class Solution {
    int getMax(int st, int end, int[] nums, int[][] dp){
        if(st>end)
            return 0;
        
        if(dp[st][end]!=-1)
            return dp[st][end];

        int takeFirst = nums[st] + Math.min(getMax(st+1, end-1, nums, dp), getMax(st+2, end, nums, dp));
        int takeLast = nums[end] + Math.min(getMax(st+1, end-1, nums, dp), getMax(st, end-2, nums, dp));

        dp[st][end] = Math.max(takeFirst, takeLast);
        return dp[st][end];
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int total = 0;
        int[][] dp = new int[n][n];

        for(int[] i: dp)
            Arrays.fill(i, -1);

        for(int i=0;i<n;i++){
            total+=nums[i];
            dp[i][i] = nums[i];
        }

        int max = getMax(0, n-1, nums, dp);

        return max>=total-max;
    }
}