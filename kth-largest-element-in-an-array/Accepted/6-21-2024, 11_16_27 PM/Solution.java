// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] count = new int[20001];
        int max = 0;
        for(int num: nums){
            count[num+10000]++;
            if(num>max)
                max = num;
        }

        for(int i=max+10000;i>=0;i--){
            if(count[i]>=k){
                return i-10000;
            }
            k-=count[i];
        }

        return -1;
    }
}