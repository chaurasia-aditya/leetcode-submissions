// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    class point implements Comparable<point>{
        int x, y;
        double dist;
        
        public point(int i, int j){
            x = i;
            y = j;
            
            dist = Math.sqrt(x*x + y*y);
        }
        
        public int compareTo(point b){
            if(dist<=b.dist)
                return -1;
            return 1;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        ArrayList<point> p = new ArrayList<>();
        
        for(int i=0;i<points.length;i++){
            p.add(new point(points[i][0], points[i][1]));
        }
        
        Collections.sort(p);
        
        int[][] res = new int[k][2];
        
        for(int i=0;i<k;i++){
            res[i][0] = p.get(i).x;
            res[i][1] = p.get(i).y;
        }
        
        return res;
    }
}