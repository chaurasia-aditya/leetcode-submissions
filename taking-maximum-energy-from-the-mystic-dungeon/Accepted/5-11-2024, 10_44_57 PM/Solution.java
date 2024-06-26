// https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        if(n == 0)
            return 0;
        
        int dp[] = new int[n+1];
        dp[n-1] = energy[n - 1];

        int ans = Integer.MIN_VALUE;

        for (int i= n-2; i >= 0; i--) {
            dp[i] = energy[i];
            if (i+k < n) {
                dp[i] += dp[i+k];
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(dp[i], ans);
        }
        
        return ans;
    }
}