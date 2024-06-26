// https://leetcode.com/problems/two-sum-iv-input-is-a-bst

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
    boolean res = false;
    boolean[] present = new boolean[20001];
    void dfs(TreeNode cur, int k){
        if(res == true || cur == null)
            return;
        
        int check = k-cur.val+10000;

        if(check>=0 && check<=20000 && present[k-cur.val+10000] == true){
            res = true;
            return;
        }
        
        present[cur.val+10000] = true;
        
        dfs(cur.left, k);
        dfs(cur.right, k);
    }

    // void getInorder(TreeNode cur, List<Integer> al){
    //     if(cur == null)
    //         return;
    //     getInorder(cur.left, al);
    //     al.add(cur.val);
    //     getInorder(cur.right, al);
    // }
    public boolean findTarget(TreeNode root, int k) {
        // List<Integer> al = new ArrayList<>();
        
        dfs(root, k);

        return res;
    }
}