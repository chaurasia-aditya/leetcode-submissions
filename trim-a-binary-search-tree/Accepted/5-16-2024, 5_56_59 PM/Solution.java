// https://leetcode.com/problems/trim-a-binary-search-tree

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
    TreeNode postOrderFix(TreeNode root, int low, int high){
        if(root == null)
        {
            return null;
        }

        root.left = postOrderFix(root.left, low, high);
        root.right = postOrderFix(root.right, low, high);

        if(root.val < low) 
        {
            TreeNode right = root.right;
            root = null;
            return right;
        }

        if(root.val > high) 
        {
            TreeNode left = root.left;
            root = null;
            return left;
        }
        
        return root;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root  == null)
            return null;
        
        return postOrderFix(root, low, high);
    }
}