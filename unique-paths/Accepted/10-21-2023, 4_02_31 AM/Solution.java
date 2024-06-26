// https://leetcode.com/problems/unique-paths

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n==1){
            return 1;
        }
        int[][] paths = new int[m+1][n+1];
        paths[1][1] = 0;
        paths[2][1] = 1;
        paths[1][2] = 1;

        for(int i=0;i<=m;i++){
            paths[i][0] = 0;
        }

        for(int j=0;j<=n;j++){
            paths[0][j] = 0;
        }

        for(int i = 1;i<=m;i++){
            for(int j=1;j<=n;j++){
                paths[i][j] += paths[i-1][j] + paths[i][j-1];
            }
        }
        return paths[m][n];
    }
}