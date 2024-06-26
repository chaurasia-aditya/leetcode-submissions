// https://leetcode.com/problems/combination-sum-iii

class Solution {
    public void backtrack(int target, int i, int count,  List<Integer> l, List<List<Integer>> res){
        if(target == 0){
            if(count == 0){
                res.add(new ArrayList<>(l));
                return;
            }else{ 
                return;
            }
        }

        if(target<0 || i==10 || count<0)
            return;

        if(i <= target){
            l.add(i);
            backtrack(target-i, i+1, count-1, l, res);
            l.remove(l.size()-1);
        }
        backtrack(target, i+1, count, l, res);
    }
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(target, 1, k, new ArrayList<Integer>(), res);

        return res;
    }
}