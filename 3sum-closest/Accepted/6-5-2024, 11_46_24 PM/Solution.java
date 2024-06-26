// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int low, high, sum;
        int cur_diff = Integer.MAX_VALUE, cur_close = 0;
        
        
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            low = i+1;
            high = n-1;

            while(low<high){
                sum = nums[i]+nums[low]+nums[high];
                if(sum==target){
                    return sum;
                }else if(sum<target){
                    low++;
                    // while(low<high && nums[low]==nums[low-1])
                    //     low++;
                }else{
                    high--;
                    while(high>low && nums[high]==nums[high+1])
                        high--;
                }
                int diff = Math.abs(sum-target);
                if(diff<cur_diff){
                    cur_diff = diff;
                    cur_close = sum;
                }
            }
        }
        
        return cur_close;
    }
}