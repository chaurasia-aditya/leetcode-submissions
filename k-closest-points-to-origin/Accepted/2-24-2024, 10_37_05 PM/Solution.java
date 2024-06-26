// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                double dist1 = Math.sqrt(a[0]*a[0]+ a[1]*a[1]);
                double dist2 = Math.sqrt(b[0]*b[0] + b[1]*b[1]);
                return dist1>dist2?1:-1;
            }
        });

        return Arrays.copyOfRange(points, 0, k);
    }
}