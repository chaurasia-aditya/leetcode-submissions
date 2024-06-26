// https://leetcode.com/problems/path-sum

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
    public boolean found = false;
    public void pathSum(TreeNode root, int remSum){
        if(found == true)
            return;
        if(remSum == root.val && root.left == null && root.right == null)
            found = true;
        if(root.left != null)
            pathSum(root.left, remSum-root.val);
        if(root.right!=null)
            pathSum(root.right, remSum-root.val);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null && targetSum>0)
            return false;
        if(root!=null)
            pathSum(root, targetSum);
        
        return found;
    }
}