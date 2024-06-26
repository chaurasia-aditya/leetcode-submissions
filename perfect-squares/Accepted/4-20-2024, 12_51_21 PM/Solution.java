// https://leetcode.com/problems/perfect-squares

class Solution {
    public int numSquares(int n) {
        int[] count = new int[n+1];

        count[0] = 0;
        count[1] = 1;

        for(int i=2;i<=n;i++){
            int min = Integer.MAX_VALUE;

            for(int j=1; j*j<=i;j++){
                int rem = i-j*j;
                if(count[rem]<min){
                    min = count[rem];
                }
            }
            count[i] = min+1;
        }

        return count[n];
    }
}