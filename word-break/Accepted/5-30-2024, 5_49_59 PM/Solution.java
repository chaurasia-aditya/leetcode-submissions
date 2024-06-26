// https://leetcode.com/problems/word-break

class Solution {
    public boolean recur(String left, Set<String> hs, Map<String, Boolean> memo){
        if(memo.containsKey(left))
            return memo.get(left);

        if(hs.contains(left))
            return true;

        for(int i=1;i<left.length();i++){
            if(hs.contains(left.substring(0, i)) && recur(left.substring(i), hs, memo)){
                memo.put(left, true);
                return true;
            }
        }

        memo.put(left, false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n =s.length();
        Set<String> hs = new HashSet<>();
        
        //DP
        // int maxLen = 0;

        // for(String str: wordDict){
        //     maxLen = maxLen<str.length()?str.length():maxLen;
        //     hs.add(str);
        // }

        // boolean[] dp = new boolean[n+1];
        // dp[0] = true;

        // for(int i=1; i<=n;i++){
        //     for(int j=i-1;j>=Math.max(i-maxLen-1, 0);j--){
        //         if(dp[j] && hs.contains(s.substring(j, i))){
        //             dp[i] = true;
        //             break;
        //         }
        //     }
        // }
        // return dp[n];


        //Recursive
        hs.addAll(wordDict);
        Map<String, Boolean> memo = new HashMap<>();
        return recur(s, hs, memo);
    }
}