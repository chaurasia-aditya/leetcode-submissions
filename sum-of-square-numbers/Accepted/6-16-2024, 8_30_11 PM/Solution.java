// https://leetcode.com/problems/sum-of-square-numbers

class Solution {
    public boolean judgeSquareSum(int c) {
        long low = 0, high = (long)Math.sqrt(c);

        while(low<=high){
            long sum = low*low+high*high;
            if(sum == c)
                return true;
            else if(sum<c)
                low++;
            else
                high--;
        }

        return false;
    }
}