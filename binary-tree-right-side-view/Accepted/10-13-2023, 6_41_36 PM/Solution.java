// https://leetcode.com/problems/binary-tree-right-side-view

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<TreeNode> level = new LinkedList();
        level.offer(root);
        
        while(!level.isEmpty()){
            int size = level.size();
            
            while (size-->0){
                TreeNode cur = level.poll();
                if (size == 0)
                    res.add(cur.val);
                
                if (cur.left != null)
                    level.offer(cur.left);
                if (cur.right != null)
                    level.offer(cur.right);
            }
        }
        
        return res;
    }
}