// https://leetcode.com/problems/count-good-nodes-in-binary-tree

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
    // public int count;
    public int dfs(TreeNode cur, int max){
        if(cur == null)
            return 0;

        if(cur.val>=max){
            max = cur.val;
            return 1+dfs(cur.left, max)+dfs(cur.right, max);
        }

        return dfs(cur.left, max)+dfs(cur.right, max);
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
}