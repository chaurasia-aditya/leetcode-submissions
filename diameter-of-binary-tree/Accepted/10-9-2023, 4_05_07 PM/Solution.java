// https://leetcode.com/problems/diameter-of-binary-tree

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
    int res = 0;

    int depth(TreeNode cur){
        if(cur == null)
            return 0;
        
        int left = depth(cur.left);
        int right = depth(cur.right);

        res = Math.max(res, left+right);//left+right is diameter at cur

        return Math.max(left,right)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }
}