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
        int left = 1+check(cur->left);
        int right = 1+check(cur->right);

        if((balanced==true) && (abs(left-right)>1)){
            balanced = false;
        }

        return max(left, right);
    }
    bool isBalanced(TreeNode* root) {
        check(root);

        return balanced;
    }
};