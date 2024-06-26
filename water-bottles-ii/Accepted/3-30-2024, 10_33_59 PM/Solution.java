// https://leetcode.com/problems/water-bottles-ii

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = 0;
        while(numBottles>=numExchange){
            res+=numExchange;
            numBottles-=numExchange;
            numExchange++;
            numBottles++;
        }
        
        res+=numBottles;
        
        return res;
    }
}