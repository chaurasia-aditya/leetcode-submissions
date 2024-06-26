// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // System.out.println(m+" "+n);
        int low = 0, high = m*n-1;
        int mid, row, col;
        while(low<=high){
            mid = low+(high - low)/2;
            // System.out.println(low+" "+mid+" "+high);
            row = mid/n;
            col = (mid)%n;
            // System.out.println(row+" "+col);
            if(matrix[row][col]>target){
                high = mid-1;
            }else if(matrix[row][col]<target){
                low = mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
}