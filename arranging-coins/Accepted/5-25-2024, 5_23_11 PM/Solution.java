// https://leetcode.com/problems/arranging-coins

class Solution {
    public int arrangeCoins(int n) {
        int levels = 1;

        while(n>=levels){
            n-=levels;
            levels++;
        }
        return levels-1;
    }
}