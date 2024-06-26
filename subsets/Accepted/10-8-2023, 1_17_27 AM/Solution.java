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

        while((i+1)<nums.length && nums[i] == nums[i+1])
            i++;
        getSub(cur, res, i+1, nums);
    }

    public List<List<Integer>> subsets(int[] nums) {      
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        getSub(new ArrayList<Integer>(), res, 0, nums);
        return res;
    }
}