// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) 
            return intervals;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        
        for(int i=1; i<intervals.length; i++) {
            int[] cur = intervals[i];
            int[] last = res.get(res.size() - 1);
            if (cur[0] > last[1]) {
                res.add(cur);
            } else if (cur[1] > last[1]) {
                last[1] = cur[1];
            }
        }
        int[][] ret = new int[res.size()][2];
        for(int i=0; i<res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}