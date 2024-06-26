// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public void dfs(int left, int i, int[] candidates, int n, List<Integer> cur, List<List<Integer>> res){
        if(left == 0){
            res.add(new ArrayList<>(cur));
            return;
        }

        if(left<0 || i == n || candidates[i]>left){
            return;
        }

        for(int j=i;j<n;j++){
            // if(candidates[i]>left)
            //     break;
            if(j>i && candidates[j] == candidates[j-1])
                continue;

            cur.add(candidates[j]);
            dfs(left-candidates[j], j+1, candidates, n, cur, res);
            cur.remove(cur.size()-1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res =  new ArrayList<>();
        Arrays.sort(candidates);
        int n = candidates.length;

        dfs(target, 0, candidates, n, new ArrayList<>(), res);

        return res;
    }
}