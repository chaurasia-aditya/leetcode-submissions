// https://leetcode.com/problems/subsets

class Solution {    
    void getSub(ArrayList<Integer> cur, List<List<Integer>> res, int i, int[] nums){
        if(i == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        getSub(cur, res, i+1, nums);
        cur.remove(cur.size()-1);
        getSub(cur, res, i+1, nums);
    }

    public List<List<Integer>> subsets(int[] nums) {      
        List<List<Integer>> res= new ArrayList<>();
        getSub(new ArrayList<Integer>(), res, 0, nums);
        return res;
    }

    //  public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     List<Integer> temp = new ArrayList<>();
    //     dfs(nums, result, 0, temp);
    //     return result;
    // }

    // public void dfs(int[] nums, List<List<Integer>> result, int index, List<Integer> temp) {
    //     result.add(new ArrayList<>(temp));

    //     for (int i = index; i < nums.length; i++) {
    //         List<Integer> newTemp = new ArrayList<>(temp);
    //         newTemp.add(nums[i]);
    //         dfs(nums, result, i+1, newTemp);
    //     }
    // }
}