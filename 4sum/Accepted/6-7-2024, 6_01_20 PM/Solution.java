// https://leetcode.com/problems/4sum

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> hs = new HashSet<>();
        int n = nums.length;
        long sum;

        int low, high;

        Arrays.sort(nums);

        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                low = j+1;
                high = n-1;

                while(low<high){
                    sum = (long)nums[i]+nums[j]+nums[low]+nums[high];

                    if(sum>target)
                        high--;
                    else if(sum<target)
                        low++;
                    else{
                        List<Integer> cur = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
                        if(!hs.contains(cur))
                            hs.add(cur);
                        low++;
                        high--;
                    }
                }
                while(j<n-2 && nums[j+1]==nums[j])
                    j++;
            }
            while(i<n-3 && nums[i+1]==nums[i])
                i++;
        }

        res.addAll(hs);
        return res;
    }
}