// https://leetcode.com/problems/consecutive-numbers-sum

class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 1;
        for(int i=2;i<Math.sqrt(2*n);i++){
            if((i*(i+1))/2 > n) 
                return count;
            if((n - (i*(i+1))/2)%i==0) 
                count++;
        }
        return count;
    }
}