// https://leetcode.com/problems/spiral-matrix-ii

class Solution {
    public int[][] generateMatrix(int n) {
        int num = 1;
        
        int[][] res = new int[n][n];
        
        int left = 0, right = n-1;
        int up = 0, down = n-1;
        int i = 0, j = 0;
        
        while(num<=n*n){
            //Right
            while(j<=right){
                res[i][j++] = num++;
            }
            up++;
            i = up;
            j = right;
            
            //Down
            while(i<=down){
                res[i++][j] = num++;
            }
            
            right--;
            j = right;
            i = down;
            
            //Left
            while(j>=left){
                res[i][j--] = num++;
            }
            down--;
            i = down;
            j = left;
            
            //Up
            
            while(i>=up){
                res[i--][j] = num++;
            }
            
            left++;
            j = left;
            i = up;
        }
        
        return res;
    }
}