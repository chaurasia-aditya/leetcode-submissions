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
        Player[] parr = new Player[n];
        for(int i=0;i<n;i++){
            parr[i] = new Player(ages[i], scores[i]); 
        }

        Arrays.sort(parr, (a,b) -> a.age == b.age ? a.score-b.score: a.age-b.age);
        
        int[] dp = new int[n];
        dp[0] = parr[0].score;
        int res = dp[0];

        for(int i=1;i<n;i++){
            dp[i] = parr[i].score;
            for(int j=0;j<i;j++){
                if(parr[j].score <= parr[i].score){
                    dp[i] = Math.max(dp[i], parr[i].score+dp[j]);
                }
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }
}