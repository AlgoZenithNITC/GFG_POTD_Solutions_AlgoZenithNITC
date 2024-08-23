



/* A binary tree node

struct Node
{
    int data;
    struct Node* left;
    struct Node* right;
    
    Node(int x){
        data = x;
        left = right = NULL;
    }
};
 */

vector<int> ans;

void solve(Node* root, int cnt) {
    if (root == NULL) return;
    
    // If we are visiting this level for the first time, add the node to the result.
    if (ans.size() == cnt) 
        ans.push_back(root->data);
    
    // Traverse left subtree first, then right subtree.
    solve(root->left, cnt + 1);
    solve(root->right, cnt + 1);
}

vector<int> leftView(Node* root) {
    // Clear the answer vector before starting.
    ans.clear();
    solve(root, 0);
    return ans;
}
