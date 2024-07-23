class Solution {
  public:
    void inorder(Node *root, vector<int> &arr) {
        if (!root)
            return;
        inorder(root->left, arr);
        arr.push_back(root->data);
        inorder(root->right, arr);
    }

    vector<int> merge(Node *root1, Node *root2) {
        vector<int> arr;
        inorder(root1, arr);
        inorder(root2, arr);
        sort(arr.begin(), arr.end());
        return arr;
    }
};
