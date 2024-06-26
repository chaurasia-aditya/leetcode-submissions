// https://leetcode.com/problems/minimum-absolute-difference-in-bst

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
    ArrayList<Integer> list = new ArrayList<>();
    public void traverse(TreeNode root){
        if(root == null)
            return;
        list.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++){
            min = Math.min(min, list.get(i+1)-list.get(i));
        }

        return min;
    }
}