// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int max_len = 1;
        int start = 0;

        for(int i=0;i<s.length();i++)
            dp[i][i] = true;
        
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                start = i;
                max_len = 2;
            }
        }

        for(int len = 3; len<=s.length(); len++){
            for (int i = 0; i<s.length()-len+1; ++i) {
                int j = i+len-1;
                if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (max_len<len) {
                        start = i;
                        max_len = len;
                    }
                }
            }
        }

        return s.substring(start, start+max_len);
    }
}