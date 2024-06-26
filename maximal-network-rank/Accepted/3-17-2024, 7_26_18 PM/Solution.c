// https://leetcode.com/problems/maximal-network-rank

int maximalNetworkRank(int n, int** roads, int size, int* roadsColSize) {
    bool added[n][n];
    int count[n];

    memset(added, false, sizeof(added));
    memset(count, 0, sizeof(count));

    int res = 0;

    for(int i=0; i<size; i++){
        int st = roads[i][0];
        int end = roads[i][1];
        count[st]++;
        count[end]++;
        added[st][end] = true;
        added[end][st]= true;
    }

    for(int i=0;i<n;i++){
        for(int j=i+1; j<n; j++){
            int total = count[i]+count[j]-(added[i][j]?1:0);
            res = res<total?total:res;
        }
    }

    return res;
}