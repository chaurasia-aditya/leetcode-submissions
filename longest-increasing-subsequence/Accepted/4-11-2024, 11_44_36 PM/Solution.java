// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    void print(int[] arr, int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        // print(dp,n);
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                dp[j] = nums[j]>nums[i]?Math.max(dp[j], dp[i]+1):dp[j];
                max = Math.max(max, dp[j]);
            }
            // print(dp, n);
        }

        return max;
    }
}