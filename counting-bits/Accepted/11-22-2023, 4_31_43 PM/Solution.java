// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        if(n == 0){
            return res;
        }

        res[0] = 0;
        res[1] = 1;

        for(int i=2;i<=n;i++){
            res[i] = res[i/2]+res[i%2];
        }

        return res;
    }
}