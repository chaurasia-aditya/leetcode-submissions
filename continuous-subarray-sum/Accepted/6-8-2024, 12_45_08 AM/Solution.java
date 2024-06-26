// https://leetcode.com/problems/continuous-subarray-sum

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == 0 && nums[i+1] == 0)
                return true;
        }

        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
            
            if(nums[i]%k == 0)
                return true;

            int j = i-2;
            while(j>=0 && nums[i]-nums[j]>=k){
                if((nums[i]-nums[j])%k == 0)
                    return true;
                j--;
            }
            
        }

        return false;
    }
}