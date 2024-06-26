// https://leetcode.com/problems/reverse-bits

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            int cur = (n&1);
            n>>>=1;
            res = res*2+cur;
        }
        return res;
    }
}