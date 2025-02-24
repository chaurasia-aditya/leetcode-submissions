// https://leetcode.com/problems/minimum-time-visiting-all-points

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int res = 0;
        
        for(int i=0;i<n-1;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            
            int x2 = points[i+1][0];
            int y2 = points[i+1][1];
            
            int h = Math.abs(x1-x2);
            int v = Math.abs(y1-y2);
            
            res+= (-Math.min(h, v)+h+v); 
        }
        
        return res;
    }
}