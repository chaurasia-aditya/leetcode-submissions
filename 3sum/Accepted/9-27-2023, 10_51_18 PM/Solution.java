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
                // System.out.println(cur);
                if(cur<req){
                    while(low<high && nums[low+1] == nums[low])
                        low++;
                    low++;
                }else if(cur>req){
                    while(high>low && nums[high-1] == nums[high])
                        high--;
                    high--;
                }else{
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low<high && nums[low+1] == nums[low])
                        low++;
                    low++;
                    while(high>low && nums[high-1] == nums[high])
                        high--;
                    high--;
                }

            }
        }
        return res;
    }
}