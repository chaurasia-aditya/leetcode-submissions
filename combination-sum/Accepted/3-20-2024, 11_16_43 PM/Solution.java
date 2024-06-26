// https://leetcode.com/problems/combination-sum

class Solution {
    public void dfs(int cur, int i, int[] candidates, List<Integer> l, List<List<Integer>> res){
        if(cur<0)
            return;
        if(cur == 0){
            res.add(new ArrayList<>(l));
            return;
        }
        for(int j = i;j<candidates.length;j++){
            l.add(candidates[j]);

            dfs(cur-candidates[j], j, candidates, l, res);

            l.remove(l.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        int n = candidates.length;

        dfs(target, 0, candidates, new ArrayList<Integer>(), res);

        return res;
    }
}