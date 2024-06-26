// https://leetcode.com/problems/minimum-time-to-make-rope-colorful

int minCost(char * colors, int* neededTime, int neededTimeSize){
    int cur_count=1;
    char cur = colors[0];
    int cur_total = neededTime[0];
    int cur_max = neededTime[0];
    
    int cost = 0;

    int n = neededTimeSize;

    for(int i=1;i<n;i++){
        if(colors[i] == cur){
            cur_count++;
            cur_total+=neededTime[i];
            if(cur_max<neededTime[i]){
                cur_max = neededTime[i];
            }
        }else{
            if(cur_count!=1){
                // printf("%d %c %d %d %d", i, cur, cur_count, cur_max, cur_total);
                cost+=(cur_total-cur_max);
            }
            cur_count = 1;
            cur = colors[i];
            cur_total = neededTime[i];
            cur_max = neededTime[i];
        }
    }
    if(cur_count!=1){
        // printf("%d %c %d %d %d", i, cur, cur_count, cur_max, cur_total);
        cost+=(cur_total-cur_max);
    }
    return cost;
}