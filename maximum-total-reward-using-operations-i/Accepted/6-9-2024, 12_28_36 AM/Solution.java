// https://leetcode.com/problems/maximum-total-reward-using-operations-i

class Solution {
    int[][] memo;
    
    int dfs(int i, int n, int cur, int[] arr){
        if(i>=n || cur>2000)
            return cur;
        else if(memo[i][cur]!=0)
            return memo[i][cur];
        int res = 0;
        if(arr[i]>cur)
            res = dfs(i+1, n, cur+arr[i], arr);
        res = Math.max(res, dfs(i+1, n, cur, arr));
        
        memo[i][cur] = res;
        return res;
        
    }
    public int maxTotalReward(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        
        memo = new int[n][2001];

        return dfs(0, n, 0, arr);
    }
}