// https://leetcode.com/problems/insert-interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }
        boolean inserted = false;
        List<int[]> res = new ArrayList<>();
        // int i=0;
        for(int j=0;j<intervals.length;){
            if(inserted){
                res.add(intervals[j]);
                j++;
                continue;
            }

            if(newInterval[1]<intervals[j][0]){
               res.add(newInterval);
               inserted = true; 
            }else if(newInterval[0]>intervals[j][1]){
                res.add(intervals[j]);
                j++;
            }else if(newInterval[0]>intervals[j][0] && newInterval[1]<intervals[j][1]){
                res.add(intervals[j]);
                j++;
                inserted = true;
            }else{
                int initial = j;
                while(j<intervals.length && intervals[j][1]<newInterval[1])
                    j++;
                if(j == intervals.length){
                    res.add(new int[]{Math.min(newInterval[0], intervals[initial][0]), Math.max(intervals[j-1][1], newInterval[1])});
                }
                else if(intervals[j][0]<=newInterval[1])
                    res.add(new int[]{Math.min(newInterval[0], intervals[initial][0]), intervals[j++][1]});
                else
                    res.add(new int[]{Math.min(newInterval[0], intervals[initial][0]), newInterval[1]});
                inserted = true;
            }
        }
        if(!inserted){
            res.add(newInterval);
        }
        int[][] resArr = new int[res.size()][2];
        resArr = res.toArray(resArr);

        return resArr; 
    }
}