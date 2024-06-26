// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        double res = 1;

        if(n < 0){
            n = -n;
            x = 1/x;
        }

        while(n!=0){
            if((n&1) == 1){
                res = res*x;
            }
            x*=x;
            n>>>=1;
        }
        return res;
    }
}