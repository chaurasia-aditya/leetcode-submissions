// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree

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
    public TreeNode createTreeIterative(int[] nums){
        if (nums.length == 0) {
            return null;
        }
 
        int n = nums.length;
        int mid = n / 2;

        TreeNode root = new TreeNode(nums[mid]);

        LinkedList<Object[]> q = new LinkedList<>();

        q.add(new Object[] { root,
                             new int[] { 0, mid - 1 } });
        q.add(new Object[] {
            root, new int[] { mid + 1, n - 1 } });
 
        while (!q.isEmpty()) {
            Object[] curr = q.poll();

            TreeNode parent = (TreeNode)curr[0];

            int[] indices = (int[])curr[1];
            int left = indices[0];
            int right = indices[1];

            if (left <= right && parent != null) {
                mid = (left + right) / 2;
                TreeNode child = new TreeNode(nums[mid]);

                if (nums[mid] < parent.val) {
                    parent.left = child;
                }
                else {
                    parent.right = child;
                }

                q.add(new Object[] {
                    child, new int[] { left, mid - 1 } });
                q.add(new Object[] {
                    child, new int[] { mid + 1, right } });
            }
        }
 
        return root;
    }
    public TreeNode createTree(int[] nums, int low, int high){
        if(low>high)
            return null;
    
        int mid = low+(high-low)/2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = createTree(nums, low, mid-1);
        cur.right = createTree(nums, mid+1, high);

        return cur;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        //return createTree(nums,0, nums.length-1);
        return createTreeIterative(nums);
    }
}