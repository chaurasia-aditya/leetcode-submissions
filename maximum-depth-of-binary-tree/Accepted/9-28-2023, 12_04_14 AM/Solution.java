// https://leetcode.com/problems/maximum-depth-of-binary-tree

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
    int max = 0;
    public void dfs(TreeNode node, int cur){
        if(node == null){
            return;
        }
        max = Math.max(cur, max);
        dfs(node.left, cur+1);
        dfs(node.right, cur+1);
    }
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return max;
    }
}