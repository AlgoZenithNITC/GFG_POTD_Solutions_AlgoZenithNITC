class Solution {
  public:
    int helper(Node* root, int &ans){
        if(!root)return 0;
        int l = helper(root->left, ans);
        int r = helper(root->right, ans);
        int val = root->data + fmax(l, 0) + fmax(r, 0);
        ans = fmax(ans, val);
        return root->data + max({l, r, 0});
    }
    int findMaxSum(Node *root) {
        // code here
        int ans = INT_MIN;
        helper(root, ans);
        return ans;
    }
};