// https://leetcode.com/problems/permutations

class Solution {
    boolean[] visited;
    void getPermute(int count, ArrayList<Integer> cur, List<List<Integer>> res, int[] nums){        
        if(count == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                cur.add(nums[i]);
                getPermute(count+1, cur, res, nums);
                cur.remove(cur.size()-1);
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        getPermute(0, new ArrayList<Integer>(), res, nums);

        return res;
    }
}