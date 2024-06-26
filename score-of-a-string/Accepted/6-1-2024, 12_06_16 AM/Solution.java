// https://leetcode.com/problems/score-of-a-string

class Solution {
    public int scoreOfString(String s) {
        int res = 0;
        for(int i=0;i<s.length()-1;i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            res+= Math.abs(c1-c2);
        }

        return res;
    }
}