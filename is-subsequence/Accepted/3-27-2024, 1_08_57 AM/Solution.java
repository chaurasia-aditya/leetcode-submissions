// https://leetcode.com/problems/is-subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0)
            return true;
        int i, j=0;

        for(char ch: t.toCharArray()){
            if(s.charAt(j) == ch)
                j++;
            if(j == s.length())
                return true;
        }

        // for(i=0, j=0;i<s.length() && j<t.length();j++){
        //     if(s.charAt(i) == t.charAt(j)){
        //         i++;
        //     }
        // }

        return false;
    }
}