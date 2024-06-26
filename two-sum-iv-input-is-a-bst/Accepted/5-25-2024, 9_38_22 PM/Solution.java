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
    boolean dfs(TreeNode cur, int k, List<Integer> al){
        if(cur == null)
            return false;
        
        if(al.contains(k-cur.val))
            return true;
        
        al.add(cur.val);
        
        return dfs(cur.left, k, al)|dfs(cur.right, k, al);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> al = new ArrayList<>();
        
        return dfs(root, k, al);
    }
}