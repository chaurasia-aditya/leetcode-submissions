// https://leetcode.com/problems/word-break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n =s.length();
        Set<String> hs = new HashSet<>();
        // hs.addAll(wordDict);
        int maxLen = 0;

        for(String str: wordDict){
            maxLen = maxLen<str.length()?str.length():maxLen;
            hs.add(str);
        }

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=1; i<=n;i++){
            for(int j=i-1;j>=Math.max(i-maxLen-1, 0);j--){
                if(dp[j] && hs.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}