// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    int l_idx, r_idx, max = 0;
    public void check(String s, int l, int h){
        while(l>=0 && h<s.length() && s.charAt(l) == s.charAt(h)){
            l--;
            h++;
        }
        if(h-l+1>max){
            max = h-l+1;
            l_idx = l+1;
            r_idx = h;
        }
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        for(int i=0;i<n;i++){
            check(s, i, i);
            check(s, i, i+1);
        }
        return s.substring(l_idx, r_idx);
    }
}