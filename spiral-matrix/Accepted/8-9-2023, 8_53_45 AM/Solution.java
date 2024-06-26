// https://leetcode.com/problems/spiral-matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int r = matrix.length;
        int c = matrix[0].length;

        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0;
        int max_r = r-1, max_c = c-1, min_r = 0, min_c = 0;

        int i=0,j=0;
        while(true){
            if(i>max_r || i<min_r || j>max_c ||j<min_c){
                break;
            }
            ans.add(matrix[i][j]);
            while((i+dir[d][0] <= max_r) && (i+dir[d][0] >= min_r) && 
            (j+dir[d][1]<=max_c) && ((j+dir[d][1]>=min_c))){
                i+=dir[d][0];
                j+=dir[d][1];
                ans.add(matrix[i][j]);
            }
            switch(d){
                case 0:{
                    min_r++;
                    break;
                }
                case 1:{
                    max_c--;
                    break;
                }
                case 2:{
                    max_r--;
                    break;
                }
                case 3:{
                    min_c++;
                    break;
                }
            }
            d=(d+1)%4;
            i+=dir[d][0];
            j+=dir[d][1];
        }
        return ans;
    }
}