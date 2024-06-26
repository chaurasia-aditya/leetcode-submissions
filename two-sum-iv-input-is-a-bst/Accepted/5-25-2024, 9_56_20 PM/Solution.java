// https://leetcode.com/problems/two-sum-iv-input-is-a-bst

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean res = false;
    void dfs(TreeNode cur, int k, List<Integer> al){
        if(res == true || cur == null)
            return;
        
        if(al.contains(k-cur.val)){
            res = true;
            return;
        }
        
        al.add(cur.val);
        
        dfs(cur.left, k, al);
        dfs(cur.right, k, al);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> al = new ArrayList<>();
        
        dfs(root, k, al);

        return res;
    }
}