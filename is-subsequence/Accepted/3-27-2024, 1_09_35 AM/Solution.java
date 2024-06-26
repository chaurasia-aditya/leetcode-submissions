// https://leetcode.com/problems/is-subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0)
            return true;
        if(s.length()>t.length())
            return false;
        int j=0;

        for(char ch: t.toCharArray()){
            if(s.charAt(j) == ch)
                j++;
            if(j == s.length())
                return true;
        }

        return false;
    }
}