pair<int, int> solve(Node* root) {
    if (!root) return {0, 0};  // {include, exclude}

    auto left = solve(root->left);
    auto right = solve(root->right);

    int include = root->data + left.second + right.second;
    int exclude = max(left.first, left.second) + max(right.first, right.second);

    return {include, exclude};
}

int getMaxSum(Node* root) {
    auto ans = solve(root);
    return max(ans.first, ans.second);
}
