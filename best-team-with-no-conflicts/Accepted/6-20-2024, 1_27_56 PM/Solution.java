// https://leetcode.com/problems/best-team-with-no-conflicts

class Solution {
    class Player{
        int age, score;

        Player(int a, int s){
            age = a;
            score = s;
        }
    }

    int[][] memo;

    int recur(int i, int prev, Player[] p, int n){
        if(i == n)
            return 0;
        
        if(memo[i][prev+1] != 0)
            return memo[i][prev+1];
        
        int curSc = p[i].score;
        int prevSc = (prev == -1?0:p[prev].score);
        int res = -1;

        if(curSc>=prevSc){
            res = recur(i+1, i, p, n)+curSc;
        }

        res = Math.max(res, recur(i+1, prev, p, n));
        return memo[i][prev+1] = res;

    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Player[] parr = new Player[n];
        for(int i=0;i<n;i++){
            parr[i] = new Player(ages[i], scores[i]); 
        }

        Arrays.sort(parr, (a,b) -> {
            if(a.age == b.age){
                return a.score-b.score;
            }
            return a.age-b.age;
        });

        memo = new int[n][n+1];
        return recur(0, -1, parr, n);
    }
}