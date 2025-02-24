// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        if(n<=2)
            return n;
        int[] count = new int[n+1];
        count[1] = 1;
        count[2] = 2;
        for(int i=3;i<=n;i++){
            count[i] = count[i-1] + count[i-2];
        }
        return count[n];
    }
}