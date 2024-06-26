// https://leetcode.com/problems/maximum-width-of-binary-tree

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

class pair{
    TreeNode node;
    int size;
    
    pair(TreeNode n, int s){
        node = n;
        size = s;
    }
};
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        int width = Integer.MIN_VALUE;
        
        LinkedList<pair> q = new LinkedList<>();
        
        q.add(new pair(root, 0));
        
        while(q.isEmpty() == false){
            int qsize = q.size();
            width = Math.max(width, q.getLast().size - q.getFirst().size + 1);
            
            for(int i=0;i<qsize;i++){
                pair cur = q.removeFirst();
                if(cur.node.left!=null){
                    q.add(new pair(cur.node.left, 2*cur.size));
                }
                if(cur.node.right!=null){
                    q.add(new pair(cur.node.right, 2*cur.size+1));
                }
            }            
        }
        return width;
    }
}