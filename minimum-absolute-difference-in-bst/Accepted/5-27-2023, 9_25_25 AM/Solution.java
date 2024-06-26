// https://leetcode.com/problems/minimum-absolute-difference-in-bst

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
    int min = Integer.MAX_VALUE;
    int prev = -1;
    public void traverse(TreeNode root){
        if(root == null)
            return;
        traverse(root.left);
        if(prev!=-1)
            min = Math.min(min, root.val-prev);
        prev=root.val;
        traverse(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;
    }
}