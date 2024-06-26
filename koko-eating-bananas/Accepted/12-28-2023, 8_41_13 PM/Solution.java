// https://leetcode.com/problems/koko-eating-bananas

class Solution {
    public boolean isValid(int[] piles, int n, int k, int h){
        int count = 0;
        for(int i=0;i<n;i++){
            count+=((piles[i]+k-1)/k);
            if(count>h){
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max= piles[0];
        for(int i=1;i<n;i++){
            max = Math.max(max, piles[i]);
        }
        int mid, low = 1, high = max;

        while(low<high){
            mid = low+(high-low)/2;
            // System.out.println(low+" "+mid+" "+high);
            if(isValid(piles, n, mid, h)){
                high=mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}