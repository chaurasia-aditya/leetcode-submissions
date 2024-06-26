// https://leetcode.com/problems/is-subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
        int cur_index,i,j;
        for(i=0, j=-1;i<s.length() && j<t.length();){
            cur_index = t.indexOf(s.charAt(i),j+1);
            if(cur_index == -1)
                return false;
            j=cur_index;
            i++;
        }
        if( i == s.length())
            return true;
        return false;
    }
}