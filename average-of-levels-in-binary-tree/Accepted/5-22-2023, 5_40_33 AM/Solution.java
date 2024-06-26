// https://leetcode.com/problems/average-of-levels-in-binary-tree

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
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> level = new LinkedList<>();
        List<Double> res = new LinkedList<>();
        int size, n;
        double curSum;
        TreeNode cur;
        level.add(root);

        while(!level.isEmpty()){
            size = level.size();
            n=size;
            curSum = 0;
            
            while(n-->0){
                cur = level.remove();
                curSum+= cur.val;

                if(cur.left!=null)
                    level.add(cur.left);
                if(cur.right!=null)
                    level.add(cur.right);
            }
            res.add(curSum/size);
        }
        return res;
    }
}