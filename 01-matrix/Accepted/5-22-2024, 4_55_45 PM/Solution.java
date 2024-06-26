// https://leetcode.com/problems/01-matrix

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] res = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j = 0; j<n;j++){
                if(mat[i][j] == 0)
                    res[i][j] = 0;
                else{
                    int min = 100000001;
                    if(i>0)
                        min = Math.min(min, res[i-1][j]+1);
                    if(j>0)
                        min = Math.min(min, res[i][j-1]+1);
                    // if(min<0)
                    //     min = Integer.MAX_VALUE;
                    res[i][j] = min;
                }
            }
        }
        
        for(int i=m-1;i>=0;i--){
            for(int j = n-1; j>=0;j--){
                int min = 100000001;
                if(i<m-1)
                    min = Math.min(min, res[i+1][j]+1);
                if(j<n-1)
                    min = Math.min(min, res[i][j+1]+1);
                if(min<0)
                    min = Integer.MAX_VALUE;
                res[i][j] = Math.min(min, res[i][j]);
            }
        }
        
        return res;
    }
}