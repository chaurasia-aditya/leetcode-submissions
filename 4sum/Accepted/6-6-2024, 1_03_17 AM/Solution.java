// https://leetcode.com/problems/4sum

class Solution {
    class Pair{
        int i, j;

        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        long sum;

        Arrays.sort(nums);

        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                for(int k=j+1;k<n-1;k++){
                    for(int l=k+1;l<n;l++){
                        sum = (long)nums[i]+nums[j]+nums[k]+nums[l];

                        if(sum == target){
                            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }else if(sum > target){
                            break;
                        }

                        while(l<n-1 && nums[l+1]==nums[l])
                            l++;
                    }
                    while(k<n-2 && nums[k+1]==nums[k])
                        k++;
                }
                while(j<n-3 && nums[j+1]==nums[j])
                    j++;
            }
            while(i<n-4 && nums[i+1]==nums[i])
                i++;
        }

        return res;
    }
}