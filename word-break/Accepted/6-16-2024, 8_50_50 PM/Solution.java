// https://leetcode.com/problems/word-break

class Solution {
    boolean backtrack(int st, int n, String s, Set<String> dict, Map<String, Boolean> memo){
        if(st>=n)
            return true;
        
        String str = s.substring(st, n);

        if(memo.containsKey(str))
            return memo.get(str);

        for(int i=st+1;i<=n;i++){
            String sub = s.substring(st, i);
            if(dict.contains(sub) && backtrack(i, n, s, dict, memo)){
                memo.put(str, true);
                return true;
            }
        }
        memo.put(str, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        // Map<String, Boolean> memo = new HashMap<>();
        int n = s.length();

        // return backtrack(0, n, s, dict, memo);
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=1;i<=n;i++){
            for(int j=i-1; j>=0;j--){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}