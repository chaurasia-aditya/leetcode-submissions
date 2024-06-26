// https://leetcode.com/problems/balanced-binary-tree

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
    boolean balanced = true;
    int helper(TreeNode cur){
        if(cur == null)
            return 0;
        
        int left = 1+helper(cur.left);
        int right = 1+helper(cur.right);

        if(balanced && Math.abs(left-right)>1)
            balanced = false;

        return Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return balanced;
    }
}