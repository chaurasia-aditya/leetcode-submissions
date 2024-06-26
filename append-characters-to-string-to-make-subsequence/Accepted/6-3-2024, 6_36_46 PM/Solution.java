// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence

class Solution {
    public int appendCharacters(String s, String t) {
        int n = s.length();
        int m = t.length();
        int j = 0;
        char cur = t.charAt(j);

        for(char ch: s.toCharArray()){
            if(ch == cur){
                j++;
                if(j == m)
                    return 0;
                cur = t.charAt(j);
            }
        }
        return m-j;
    }
}