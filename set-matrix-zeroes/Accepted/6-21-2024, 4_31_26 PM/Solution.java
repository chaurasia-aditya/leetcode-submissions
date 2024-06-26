// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row0 = false, col0 = false;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    if(i==0)
                        row0=true;
                    if(j==0)
                        col0 = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] ==  0)
                    matrix[i][j] = 0;
            }
        }
        if(col0) {
            for(int i=0;i<m;i++) {
                matrix[i][0] = 0;
            }
        }

        if(row0) {
            for(int j=0;j<n;j++) {
                matrix[0][j] = 0;
            }
        }
    }
}