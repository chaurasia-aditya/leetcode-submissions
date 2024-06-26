// https://leetcode.com/problems/best-team-with-no-conflicts

class Solution {
    class Player{
        int age, score;

        Player(int a, int s){
            age = a;
            score = s;
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] parr = new int[n][2];
        for(int i=0;i<n;i++){
            parr[i][0] = ages[i]; 
            parr[i][1] = scores[i]; 
        }

        Arrays.sort(parr, (a,b) -> a[0] == b[0] ? a[1]-b[1]: a[0]-b[0]);
        
        int[] dp = new int[n];
        dp[0] = parr[0][1];
        int res = dp[0];
        int cur;

        for(int i=1;i<n;i++){
            dp[i] = parr[i][1];
            cur = parr[i][1];
            for(int j=0;j<i;j++){
                if(parr[j][1] <= cur){
                    dp[i] = Math.max(dp[i], cur+dp[j]);
                }
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }
}