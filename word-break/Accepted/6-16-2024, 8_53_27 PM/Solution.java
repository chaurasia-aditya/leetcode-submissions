// https://leetcode.com/problems/word-break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        int n = s.length();

        int max = 0;

        for(String str:wordDict){
            max = max<str.length()?str.length():max;
            dict.add(str);
        }

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=1;i<=n;i++){
            for(int j=i-1; j>=Math.max(i-max-1, 0);j--){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}