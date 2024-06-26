// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    class point implements Comparable<point>{
        public int x, y;
        double dist;

        point(int x, int y){
            this.x = x;
            this.y = y;
            this.dist = Math.sqrt(x*x + y*y);
        }

        public int compareTo(point p){
            return this.dist>p.dist?1:-1;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] res = new int[k][2];
        // point parr[] = new point[n];
        // for(int i=0;i<n;i++){
        //     parr[i] = new point(points[i][0],points[i][1]);
        // }

        // Arrays.sort(parr);

        // for(int i=0;i<k;i++){
        //     res[i][0] = parr[i].x;
        //     res[i][1] = parr[i].y;
        // }

        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                double dist1 = Math.sqrt(a[0]*a[0]+ a[1]*a[1]);
                double dist2 = Math.sqrt(b[0]*b[0] + b[1]*b[1]);
                return dist1>dist2?1:-1;
            }
        });

        for(int i=0;i<k;i++){
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }

        return res;
    }
}