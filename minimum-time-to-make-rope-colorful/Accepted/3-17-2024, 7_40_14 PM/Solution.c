// https://leetcode.com/problems/minimum-time-to-make-rope-colorful

int minCost(char * colors, int* neededTime, int neededTimeSize){
    int cost = 0;
    char cur = colors[0];
    int cur_time = neededTime[0];

    for(int i=1;i<neededTimeSize;i++){
        if(colors[i] == cur){
            if(neededTime[i]<cur_time){
                cost+=neededTime[i];
            }else{
                cost+=cur_time;
                cur_time = neededTime[i];
            }
        }else{
            cur = colors[i];
            cur_time = neededTime[i];
        }
    }

    return cost;
}