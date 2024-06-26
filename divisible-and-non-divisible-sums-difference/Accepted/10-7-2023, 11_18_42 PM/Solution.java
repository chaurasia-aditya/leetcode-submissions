// https://leetcode.com/problems/divisible-and-non-divisible-sums-difference

class Solution {
    public int differenceOfSums(int n, int m) {
        int total = (n*(n+1))/2;
        int num2;
        int count = n/m;
        num2 = (count)*(2*m + (count-1)*m);
        return total-num2;
    }
}