// https://leetcode.com/problems/minimum-path-sum

int min(const int a, const int b){
    if(a<b)
        return a;
    return b;
}
int minPathSum(int** grid, int gridSize, int* gridColSize) {
    int m = gridSize;
    int n = *gridColSize;

    if(m == 1 && n==1){
        return grid[0][0];
    }

    int dp[m][n];

    dp[0][0] = grid[0][0];

    for(int j=1;j<n;j++){
        dp[0][j] = grid[0][j] + dp[0][j-1];
    }

    for(int i=1;i<m;i++){
        dp[i][0] = grid[i][0] + dp[i-1][0];
    }

    for(int i=1;i<m;i++){
        for(int j=1;j<n;j++){
            dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
        }
    }

    return dp[m-1][n-1];
}