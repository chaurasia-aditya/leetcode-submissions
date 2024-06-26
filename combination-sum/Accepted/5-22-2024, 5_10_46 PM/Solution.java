// https://leetcode.com/problems/combination-sum

class Solution {
    public void backtrack(int i, int left, int n, int[] arr, List<Integer> cur, List<List<Integer>> res){        
        if(left == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        
        if(left<0 || i==n)
            return;
        
        if(arr[i]<=left){
            cur.add(arr[i]);
            backtrack(i, left-arr[i], n, arr, cur, res);
            cur.remove(cur.size()-1);
        }
        backtrack(i+1, left, n, arr, cur, res);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        
        List<List<Integer>> res = new ArrayList<>();
        
        
        backtrack(0, target, n, candidates, new ArrayList<>(), res);
        
        return res;
    }
}