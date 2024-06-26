// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0, rsum=0;
        int i = 0;
        for(;i<k;i++){
            lsum+=cardPoints[i];
        }

        int max = lsum;

        for(int j=cardPoints.length-1;j>=cardPoints.length-k;j--){
            lsum-=cardPoints[--i];
            rsum+=cardPoints[j];
            max = max>(lsum+rsum)?max:lsum+rsum;
        }

        return max;
    }
}