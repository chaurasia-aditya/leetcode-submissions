// https://leetcode.com/problems/combination-sum

class Solution {
    public void dfs(int cur, int i, int[] candidates, List<Integer> l, List<List<Integer>> res){
        if(cur<0 || i==candidates.length)
            return;
        if(cur == 0){
            res.add(new ArrayList<>(l));
            return;
        }
        if(candidates[i] <= cur){
            l.add(candidates[i]);
            dfs(cur-candidates[i], i, candidates, l, res);
            l.remove(l.size()-1);
        }
        dfs(cur, i+1, candidates, l, res);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        int n = candidates.length;

        dfs(target, 0, candidates, new ArrayList<Integer>(), res);

        return res;
    }
}