// https://leetcode.com/problems/subsets-ii

class Solution {
    void getSubsets(int i, ArrayList<Integer> cur, List<List<Integer>> res, int[] nums){
        if(i == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        getSubsets(i+1, cur, res, nums);
        cur.remove(cur.size()-1);

        while((i+1)<nums.length && nums[i] == nums[i+1])
            i++;
        getSubsets(i+1, cur, res, nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        getSubsets(0, new ArrayList<Integer>(), res, nums);

        return res;
    }
}