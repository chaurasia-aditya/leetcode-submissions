// https://leetcode.com/problems/car-fleet

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int res = 0;
        float time[] = new float[target+1];
        for(int i=0;i<position.length;i++){
            time[position[i]] = (target-position[i])/(float)speed[i];
        }

        float last = 0;
        for(int i=target;i>=0;i--){
            if(time[i]>last){
                last = time[i];
                res++;
            }
        }

        return res;
    }
}