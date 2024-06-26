// https://leetcode.com/problems/combination-sum

class Solution {
    void generateCombinations(int i, int target, int n, int[] candidates, ArrayList<Integer> cur, List<List<Integer>> res){
        if(target<0 || i==n)
            return;
        
        if(target == 0){
            res.add(new ArrayList(cur));
            return;
        }
        
        
        cur.add(candidates[i]);
        generateCombinations(i, target-candidates[i], n, candidates, cur, res);
        cur.remove(cur.size()-1);
                
        generateCombinations(i+1, target, n, candidates, cur, res);
        
    }
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        
        generateCombinations(0, target, n, candidates, new ArrayList<>(), res);
        
        return res;
    }
}