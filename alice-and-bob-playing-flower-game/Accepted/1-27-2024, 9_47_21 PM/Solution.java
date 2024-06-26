// https://leetcode.com/problems/alice-and-bob-playing-flower-game

class Solution {
    public long flowerGame(int n, int m) {
        long res = 0;
        
        long neven = n/2;
        long meven = m/2;
        
        long nodd = n-neven;
        long modd = m-meven;
        
        res = neven*modd + nodd*meven;
        
        return res;
    }
}