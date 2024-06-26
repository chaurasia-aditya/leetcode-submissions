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
    public int count;
    public void dfs(TreeNode cur, int max){
        if(cur == null)
            return;
        
        if(cur.val>=max){
            count++;
            max = cur.val;
        }

        dfs(cur.left, max);
        dfs(cur.right, max);
    }
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);

        return count;
    }
}