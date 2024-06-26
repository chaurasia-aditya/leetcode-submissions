// https://leetcode.com/problems/house-robber

class Solution {
    int[] memo;
    int dfs(int in, int n, int[] nums){
        if(in>=n){
            return 0;
        }

        if(memo[in]!=-1)
            return memo[in];

        int robCur = nums[in] + dfs(in+2, n, nums);
        int skipCur = dfs(in+1, n, nums);

        memo[in] = Math.max(robCur, skipCur);
        
        return memo[in];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);

        return dfs(0, n, nums);
    }
}