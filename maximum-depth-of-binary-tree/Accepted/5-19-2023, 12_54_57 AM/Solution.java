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
    public int maxdepth;
    public void depth(TreeNode cur, int depth){
        if(cur == null){
            if(depth>maxdepth)
                maxdepth = depth;
            return;
        }
        depth(cur.left, depth+1);
        depth(cur.right, depth+1);
    }
    public int maxDepth(TreeNode root) {
        maxdepth = 0;
        depth(root,0);
        return maxdepth;
    }
}