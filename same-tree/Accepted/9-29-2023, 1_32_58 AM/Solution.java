// https://leetcode.com/problems/same-tree

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
    boolean notSame = false;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(notSame || (p == null && q!=null) || (p!=null && q==null))
        {
            notSame = true;
            return false;
        }
        if(p==null && q==null)
            return true;
        if(p.val != q.val)
        {
            notSame = true;
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}