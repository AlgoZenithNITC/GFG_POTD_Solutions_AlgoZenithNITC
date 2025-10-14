/*
class Node {
  public:
    int data;
    Node* left;
    Node* right;

    // Constructor to initialize a new node
    Node(int val) {
        data = val;
        left = NULL;
        right = NULL;
    }
};
*/
class Solution {
public:
    int s;

    int nodeSum(Node* root, int l, int r) {
        s = 0;
        recurse(root, l, r);
        return s;
    }

private:
    void recurse(Node* root, int l, int r) {
        if (root != nullptr) {
            if (l <= root->data && root->data <= r)
                s += root->data;
            recurse(root->left, l, r);
            recurse(root->right, l, r);
        }
    }
};
