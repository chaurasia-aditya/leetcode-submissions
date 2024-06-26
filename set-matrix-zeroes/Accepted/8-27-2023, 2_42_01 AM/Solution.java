// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> r= new HashSet<>();
        HashSet<Integer> c= new HashSet<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    r.add(i);
                    c.add(j);
                }
            }
        }

        for(Integer x:r){
            for(int j = 0;j<n;j++){
                matrix[x][j] = 0;
            }
        }

        for(Integer y:c){
            for(int i = 0;i<m;i++){
                matrix[i][y] = 0;
            }
        }
    }
}