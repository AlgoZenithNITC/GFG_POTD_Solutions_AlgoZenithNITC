class Solution
{
    public:
    vector<int> ans;
    vector<int> solve(Node *root)
    {
        queue<Node *> q;
        if(root)
            q.push(root);
        while(q.size())
        {
            Node *front = q.front();
            q.pop();
            ans.push_back(front->data);
            if(front->left)
                q.push(front->left);
            if(front->right)
                q.push(front->right);
            
        }
        return ans;
    }
    vector<int> levelOrder(Node* root)
    {
        return solve(root);
    }
};
