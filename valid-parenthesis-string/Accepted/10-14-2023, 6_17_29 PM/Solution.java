// https://leetcode.com/problems/valid-parenthesis-string

class Solution {
    public boolean checkValidString(String s) {
        int openMax = 0, openMin = 0;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                openMin++;
                openMax++;
            } else if (ch== ')') {
                if (openMin > 0) {
                    openMin--;
                }
                openMax--;
            } else {
                if (openMin > 0) {
                    openMin--;
                }
                openMax++;
            }
            if (openMax < 0) {
                return false;
            }
        }
        return openMin == 0;
    }
}