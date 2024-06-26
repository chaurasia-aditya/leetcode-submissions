// https://leetcode.com/problems/flipping-an-image

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length;
        int n = image[0].length;
        // int[][] res = new int[m][n];
        
        for(int i=0;i<m;i++){
            int j = 0;
            int k = n-1;
            
            while(j<k){
                int temp = (image[i][j] ^ 1);
                image[i][j++] = (image[i][k] ^1);
                image[i][k--] = temp;
            }
            if(j == k){
                image[i][j] = image[i][j]^1;
            }
        }
        
        return image;
    }
}