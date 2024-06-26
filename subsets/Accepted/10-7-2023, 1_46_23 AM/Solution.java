// https://leetcode.com/problems/subsets

class Solution {
    List<List<Integer>> res= new ArrayList<>();
    
    void getSub(ArrayList<Integer> cur, int i, int[] nums){
        if(i == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        getSub(cur, i+1, nums);
        cur.remove(cur.size()-1);
        getSub(cur,i+1, nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        // arr = new boolean[n.length];
        
        getSub(new ArrayList<Integer>(), 0, nums);
        return res;
    }
}