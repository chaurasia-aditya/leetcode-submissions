// https://leetcode.com/problems/number-of-islands

void dfs(int i, int j, char** grid, int m, int n){
    if(i<0 || i>=m || j<0 || j>=n || !(grid[i][j]-'0'))
        return;

    grid[i][j] = '0';

    dfs(i+1, j, grid, m, n);
    dfs(i-1, j, grid, m, n);
    dfs(i, j+1, grid, m, n);
    dfs(i, j-1, grid, m, n);
}
int numIslands(char** grid, int gridSize, int* gridColSize) {
    int count = 0;
    int m = gridSize;
    int n = *gridColSize;

    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]-'0'){
                count++;
                dfs(i, j, grid, m, n);
            }
        }
    }
    return count;
}