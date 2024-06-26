// https://leetcode.com/problems/modify-the-matrix

class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] res = new int[m][n];
        int[] max = new int[n];
        
        int cur = -2;
        for(int i=0;i<n;i++){
            cur = -2;
            for(int j=0;j<m;j++){
                cur = Math.max(cur, matrix[j][i]);
            }
            max[i] = cur;
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j] = matrix[i][j];
                if(res[i][j] == -1){
                    res[i][j] = max[j];
                }
            }
        }
        return res;
    }
}