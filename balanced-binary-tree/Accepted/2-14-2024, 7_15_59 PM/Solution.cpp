// https://leetcode.com/problems/balanced-binary-tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    bool balanced = true;
public:
    int check(TreeNode* cur){
        if(cur == nullptr){
            return 0;
        }
        int left = check(cur->left);
        if(left == -1)
            return -1;
        int right = check(cur->right);

        if(right == -1 || (abs(left-right)>1)){
            return -1;
        }

        return 1+max(left, right);
    }
    bool isBalanced(TreeNode* root) {
        if(check(root) == -1)
            return false;
        return true;        
    }
};