// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int n = nums.length;

        Arrays.sort(nums);
        int low, high, sum, cur;
        
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            low = i+1;
            high = n-1;

            while(low<high){
                sum = nums[i]+nums[low]+nums[high];
                if(sum<0){
                    low++;
                }else if(sum>0){
                    high--;
                }else{
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    while(high>low && nums[low]==nums[low-1])
                        low++;
                }
            }
        }
        
        return res;
    }
}