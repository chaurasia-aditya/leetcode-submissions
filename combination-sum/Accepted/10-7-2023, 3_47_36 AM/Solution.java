// https://leetcode.com/problems/combination-sum

class Solution {
    void helper(int index, ArrayList<Integer> cur, List<List<Integer>> res, int left, int[]candidates){
        if(left == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(left<0){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            cur.add(candidates[i]);
            helper(i, cur, res, left - candidates[i], candidates);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, new ArrayList<>(), res, target, candidates);
        return res;
    }
}