// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        int[] a = new int[n+1];
        a[1] = 1;
        a[2] = 2;
        for(int i=3;i<n+1;i++){
            a[i] = a[i-1] + a[i-2];
        }
        return a[n];
    }
}