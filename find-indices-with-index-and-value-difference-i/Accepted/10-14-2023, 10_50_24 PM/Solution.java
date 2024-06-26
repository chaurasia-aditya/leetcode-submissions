// https://leetcode.com/problems/find-indices-with-index-and-value-difference-i

class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] res = {-1, -1};
        // int[] min = new int[nums.length];
        // int[] max = new int[nums.length];
        // min[0] = nums[0];
        // max[nums.length-1] = nums[nums.length-1];
        // for(int i=1;i<nums.length;i++){
        //     min[i] = Math.min(min[i-1], nums[i]);
        //     max[nums.length-1-i] = Math.max(max[nums.length-i], nums[nums.length-1-i]);
        // }
        // for(int i=0;i<nums.length-indexDifference;i++){
        //     if(Math.abs(min[i]-max[indexDifference+i])>=valueDifference || (Math.abs(max[i]-min[indexDifference+i])>=valueDifference)){
        //         res[0] = i;
        //         res[1] = indexDifference+i;
        //         break;
        //     }
        // }
        for(int i = 0;i<nums.length-indexDifference;i++){
            for(int j = i+indexDifference; j<nums.length;j++){
                if(Math.abs(nums[i] - nums[j]) >= valueDifference){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}