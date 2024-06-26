// https://leetcode.com/problems/happy-number

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<Integer>();
        int cur, rem;
        while (hs.add(n)) {
            cur = 0;
            while (n > 0) {
                rem = n%10;
                cur += rem*rem;
                n /= 10;
            }
            if (cur == 1)
                return true;
            else
                n = cur;

        }
        return false;
    }
}