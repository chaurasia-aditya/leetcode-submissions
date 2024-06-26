// https://leetcode.com/problems/summary-ranges

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int j;
        for(int i=0;i<nums.length;){
            for(j=i+1;j<nums.length;j++){
                if(nums[j]!=nums[j-1]+1)
                    break;
            }
            if(j==i+1){
                res.add(Integer.toString(nums[i]));
            }else{
                res.add(nums[i]+"->"+nums[j-1]);
            }
            i=j;
        }
        return res;
    }
}