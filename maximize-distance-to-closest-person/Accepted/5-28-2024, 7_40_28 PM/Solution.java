// https://leetcode.com/problems/maximize-distance-to-closest-person

class Solution {
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int n = seats.length;
        
        int st = seats[0] == 1?0:-1;
        
        for(int i=1; i<n;i++){
            if(seats[i] == 1){
                if(st == -1)
                    max = i;
                else{
                    int val = (int)Math.ceil((i-st-1)/2.0);
                    max = Math.max(val, max);
                }
                st = i;
            }
        }
        if(st!=n-1){
            max = Math.max(max, n-1-st);
        }
        
        return max;
    }
}