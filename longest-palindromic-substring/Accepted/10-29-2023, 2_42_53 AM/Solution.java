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
            // res = s.substring(l+1, high);
        }
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int low, high;
        // int max = 0;
        String res = "";
        for(int i=0;i<n;i++){
            // low = i;
            // high = i;
            // while(low>=0 && high<n && s.charAt(low) == s.charAt(high)){
            //     low--;
            //     high++;
            // }
            // if(high-low+1>max){
            //     max = high-low+1;
            //     res = s.substring(low+1, high);
            // }
            // low = i;
            // high = i+1;
            // while(low>=0 && high<n && s.charAt(low) == s.charAt(high)){
            //     low--;
            //     high++;
            // }
            // if(high-low+1>max){
            //     max = high-low+1;
            //     res = s.substring(low+1, high);
            // }
            check(s, i, i);
            check(s, i, i+1);
        }
        return s.substring(l_idx, r_idx);
    }
}