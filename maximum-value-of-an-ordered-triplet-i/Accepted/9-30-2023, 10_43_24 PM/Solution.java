// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i

class Solution {
    public long maximumTripletValue(int[] nums) {
        // int[] max = new int[nums.length];
        // int[] min = new int[nums.length];
        // max[0] = Integer.MIN_VALUE;
        // min[nums.length-1] = Integer.MAX_VALUE;
        // for(int i=1;i<nums.length;i++){
        //     max[i] = Math.max(max[i-1], nums[i]);
        //     min[n-1-i] = Math.min(min[n-i], nums[n-i]);
        // }
        long res = Long.MIN_VALUE;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k = j+1;k<nums.length;k++){
                    System.out.println("Here");
                    res = Math.max(res, ((long)(nums[i] - nums[j])*nums[k]));
                }
            }
        }
        return res>=0?res:0;
    }
}