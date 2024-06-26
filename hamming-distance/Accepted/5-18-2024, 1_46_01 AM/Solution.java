// https://leetcode.com/problems/hamming-distance

class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int res = 0;
        while(xor>0){
            res += (xor&1)==0?0:1;
            xor>>=1;
        }
        
        return res;
    }
}