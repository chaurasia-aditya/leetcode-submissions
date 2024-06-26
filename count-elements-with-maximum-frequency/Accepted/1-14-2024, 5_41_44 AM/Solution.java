// https://leetcode.com/problems/count-elements-with-maximum-frequency

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        int max = Integer.MIN_VALUE;
        int c=0;
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
            if(count[nums[i]]>max){
                max = count[nums[i]];
                c = 1;
            }else if(count[nums[i]]==max){
                c++;
            }
        }
        return c*max;
    }
}