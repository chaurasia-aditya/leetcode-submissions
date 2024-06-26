// https://leetcode.com/problems/maximal-network-rank

int maximalNetworkRank(int n, int** roads, int size, int* roadsColSize) {
    int grid[n][n];
    memset(grid, 0, sizeof(grid));
    int count[n];
    memset(count, 0, sizeof(count));

    for(int i=0;i<size;i++){
        grid[roads[i][0]][roads[i][1]] = 1;
        grid[roads[i][1]][roads[i][0]] = 1;
        count[roads[i][0]]++;
        count[roads[i][1]]++;
    }
    int max = INT_MIN;


    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            int rank = count[i]+count[j] - grid[i][j];
            max = max>rank?max:rank;
        }
    }
    return max;
}