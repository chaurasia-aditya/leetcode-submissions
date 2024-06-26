// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int low, high, req, cur;
        Arrays.sort(nums);

        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]== nums[i-1])
                continue;
            low = i+1;
            high = n-1;
            req = -nums[i];
            while(low<high){
                cur = nums[low]+nums[high];
                if(cur<req){
                    low++;
                }else if(cur>req){
                    high--;
                }else{
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    while(high>low && nums[low] == nums[low-1])
                        low++;
                }
            }
        }
        return res;
    }
}