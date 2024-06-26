// https://leetcode.com/problems/permutations-ii

class Solution {
    void backtrack(int size, int n, int[] nums, boolean[] visited, ArrayList<Integer> cur, List<List<Integer>> res){
        if(size == n){
            res.add((List)cur.clone());
            return;
        }

        for(int i=0;i<n;){
            if(!visited[i]){
                visited[i] = true;
                cur.add(nums[i]);
                backtrack(size+1, n, nums, visited, cur, res);
                cur.remove(cur.size()-1);
                visited[i] = false;
                i++;
                while(i<n && nums[i] == nums[i-1])
                    i++;
                continue;
            }
            i++;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[n];

        backtrack(0, n, nums, visited, new ArrayList<Integer>(), res);
        return res;
    }
}