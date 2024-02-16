
class Solution
{
public:
    Node *flattenBST(Node *root)
    {
        // code here
        
        vector<Node*> ans;
        func(ans, root);
        Node* head = nullptr, *prev = nullptr;
        if (!ans.empty()) {
            head = ans[0];
            head->left = nullptr;
            prev = head;
            for (int i = 1; i < ans.size(); i++) {
                prev->right = ans[i];
                ans[i]->left = NULL;
                prev = ans[i];
            }
        }
        return head;
    }
    void func(vector<Node*> &ans, Node* root){
        if(!root) return;
        func(ans,root->left);
        ans.push_back(root);
        func(ans,root->right);
    }
};
