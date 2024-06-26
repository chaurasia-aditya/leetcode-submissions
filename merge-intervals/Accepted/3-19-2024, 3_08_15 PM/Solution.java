// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0)
            return intervals;

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });

        List<int[]> l = new ArrayList<>();
        l.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[] cur = intervals[i];
            int[] last = l.get(l.size() - 1);
            if (cur[0] > last[1]) {
                l.add(cur);
            } else if (cur[1] > last[1]) {
                last[1] = cur[1];
            }
        }

        int[][] res = new int[l.size()][2];
        res = l.toArray(res);

        return res;
    }
}