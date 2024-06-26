// https://leetcode.com/problems/leaf-similar-trees

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafValues1 = new ArrayList<>();
        List<Integer> leafValues2 = new ArrayList<>();

        leaf(root1, leafValues1);
        leaf(root2, leafValues2);

        return leafValues1.equals(leafValues2);
    }

    private void leaf(TreeNode node, List<Integer> leafValues) {
        if (node == null) {
            return;
        }

        if (node.left != null || node.right != null) {
            leaf(node.left, leafValues);
            leaf(node.right, leafValues);
        } else {
            leafValues.add(node.val);
        }
    }
}