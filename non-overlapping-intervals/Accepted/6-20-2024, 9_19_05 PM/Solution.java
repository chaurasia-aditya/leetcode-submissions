// https://leetcode.com/problems/non-overlapping-intervals

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);

        int end = intervals[0][1];
        int count = 0;
        for(int i = 1; i<intervals.length;i++){
            int cur_st = intervals[i][0];
            int cur_end = intervals[i][1];
            
            if(cur_st>=end){
                end = cur_end;
            }else{
                count++;
            }
        }

        return count;
    }
}