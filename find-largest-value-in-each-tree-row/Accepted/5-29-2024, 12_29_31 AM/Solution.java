// https://leetcode.com/problems/find-largest-value-in-each-tree-row

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            long max = Long.MIN_VALUE;
            
            while(size-->0){
                TreeNode cur = q.poll();
                max = Math.max(max, cur.val);
                
                if(cur.left!=null){
                    q.add(cur.left);
                }
                
                if(cur.right!=null)
                    q.add(cur.right);
            }
            
            res.add((int)max);
        }
        
        return res;
    }
}