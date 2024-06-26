// https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds

class Solution {
    public int numberOfChild(int n, int k) {
        int rounds = k/(n-1);
        int diff = k%(n-1);
        // System.out.println(rounds+" "+diff);
        if((rounds&1) == 0)
            return diff;
        else
            return n-diff-1;
    }
}