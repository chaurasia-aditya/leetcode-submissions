// https://leetcode.com/problems/spiral-matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int row_low = 0, row_high = matrix.length-1;
        int col_low = 0, col_high = matrix[0].length-1;
        int i = 0, j = 0;
        int i_inc = 0, j_inc = 1;
        while(row_low<=row_high || col_low<=col_high){
            // System.out.print(row_low+" "+row_high+" "+col_low+" "+col_high+"||");
            while(i>=row_low && i<=row_high && j>=col_low && j<=col_high){
                // System.out.print(matrix[i][j]+" ");
                res.add(matrix[i][j]);
                i+=i_inc;
                j+=j_inc;
            }
            i-=i_inc;
            j-=j_inc;
            // System.out.println("||"+i+" "+j);

            if(i_inc==0 && j_inc==1){
                row_low++;
                i_inc = 1;
                j_inc = 0;
            }else if(i_inc==1 && j_inc==0){
                col_high--;
                i_inc = 0;
                j_inc = -1;
            }else if(i_inc==0 && j_inc==-1){
                row_high--;
                i_inc = -1;
                j_inc = 0;
            }else if(i_inc==-1 && j_inc==0){
                col_low++;
                i_inc = 0;
                j_inc = 1;
            }
            i+=i_inc;
            j+=j_inc;
        }
        return res;
    }
}