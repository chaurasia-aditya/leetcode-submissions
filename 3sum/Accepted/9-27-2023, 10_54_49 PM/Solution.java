// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int low, high, req, cur;
        boolean lloop = false, hloop = false;
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
                    lloop = true;
                }else if(cur>req){
                    hloop = true;
                }else{
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    lloop = true;
                    hloop = true;
                }
                if(lloop){
                    while(low<high && nums[low+1] == nums[low])
                        low++;
                    low++;
                    lloop = false;
                }
                if(hloop){
                    while(high>low && nums[high-1] == nums[high])
                        high--;
                    high--;
                    hloop = false;
                }
            }
        }
        return res;
    }
}