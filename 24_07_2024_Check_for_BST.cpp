#include <iostream>

struct TreeNode {
    int data;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int val) : data(val), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    Solution() : prev(nullptr) {}

    // Function to check whether a Binary Tree is BST or not.
    bool isBST(TreeNode* root) {
        return inorder(root);
    }

private:
    int* prev;

    bool inorder(TreeNode* root) {
        if (root == nullptr) {
            return true;
        }

        if (!inorder(root->left)) {
            return false;
        }

        // Check BST condition
        if (prev != nullptr && root->data <= *prev) {
            return false;
        }

        prev = &root->data; // update prev to current node's value

        return inorder(root->right);
    }
};

