// https://leetcode.com/problems/find-the-n-th-value-after-k-seconds

class Solution {
    int MOD = 1000000007;
    
    public int valueAfterKSeconds(int n, int k) {        
        long[] arr = new long[n];
        long[] prefixSum = new long[n+1];

        for (int i=0; i<n; i++) {
            arr[i] = 1;
        }

        for (int second = 0; second < k; second++) {
            prefixSum[0] = 0;
            for (int i = 0; i < n; i++) {
                prefixSum[i+1] = (prefixSum[i]+arr[i])%MOD;
            }
            for (int i=0; i<n; i++) {
                arr[i] = prefixSum[i+1];
            }
        }

        return (int)arr[n-1];
    }
}