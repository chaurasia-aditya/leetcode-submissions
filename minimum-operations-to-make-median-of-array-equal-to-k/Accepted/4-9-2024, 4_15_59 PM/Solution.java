// https://leetcode.com/problems/minimum-operations-to-make-median-of-array-equal-to-k

class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long count = 0;

        int mid = n/2;

        if(nums[mid] < k){
            for(int i=mid;i<n;i++){
                if(nums[i]<k){
                    count+=k-nums[i];
                }
            }
        }else if(nums[mid]>k){
            for(int i=0;i<mid+1;i++){
                if(nums[i]>k){
                    count+=nums[i]-k;
                }
            }
        }else{
            count = 0;
        }

        return count;
    }
}