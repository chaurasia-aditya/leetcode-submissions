// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m*n-1;
        int mid, row, col;
        while(low<=high){
            mid = low+(high - low)/2;
            row = mid/n;
            col = (mid)%n;
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