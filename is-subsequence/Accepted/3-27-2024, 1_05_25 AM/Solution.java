// https://leetcode.com/problems/is-subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean isSub = false;
        int i, j;

        for(i=0, j=0;i<s.length() && j<t.length();j++){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
        }

        return i==s.length();
    }
}