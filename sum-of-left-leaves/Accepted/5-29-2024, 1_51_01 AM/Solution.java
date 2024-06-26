// https://leetcode.com/problems/sum-of-left-leaves

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

    public int sumOfLeftLeaves(TreeNode cur) {
        if(cur == null)
            return 0;

        int res = 0;

        if(cur.left!=null){
            if(cur.left.left == null && cur.left.right == null)
                res+=cur.left.val;
            else
                res += sumOfLeftLeaves(cur.left);
        }

        if(cur.right!=null)
            res+= sumOfLeftLeaves(cur.right);

        return res;


    }
}