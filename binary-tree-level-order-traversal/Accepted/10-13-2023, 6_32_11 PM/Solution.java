// https://leetcode.com/problems/binary-tree-level-order-traversal

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        Queue<TreeNode> level = new LinkedList<>();
        List<Integer> cur = new ArrayList<>();
        level.add(root);
        int count = 1;
        while(!level.isEmpty()){
            TreeNode c = level.poll();

            cur.add(c.val);

            if(c.left!=null){
                level.add(c.left);
            }

            if(c.right!=null){
                level.add(c.right);
            }

            count--;
            if(count == 0){
                res.add(cur);
                cur = new ArrayList<>();
                count = level.size();
            }
        }    
        return res;    
    }
}