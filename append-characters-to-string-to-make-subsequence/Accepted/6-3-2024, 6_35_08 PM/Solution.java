// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence

class Solution {
    public int appendCharacters(String s, String t) {
        int n = s.length();
        int m = t.length();
        int j = 0;

        for(int i=0;i<n;i++){
            if(s.charAt(i) == t.charAt(j)){
                j++;
            }
            if(j == m)
                return 0;
        }
        return m-j;
    }
}