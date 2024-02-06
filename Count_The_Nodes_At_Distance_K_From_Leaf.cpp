class Solution
{
    public:
    set<Node *> ans; 
    void solve(Node *root, int lvl, vector<Node *> v, int k) { 
        if(!root) 
            return; 
             
        v.push_back(root); 
        if(!root->left and !root->right)  
        { 
            int ind = lvl - k; 
            if(ind >= 0) 
                ans.insert(v[ind]); 
                 
            return; 
        } 
         
        solve(root->left, lvl + 1, v, k); 
        solve(root->right, lvl + 1, v, k); 
    } 
     
    int printKDistantfromLeaf(Node* root, int k) 
    { 
        ans.clear(); 
        vector<Node *> v; 
        solve(root, 0, v, k); 
        return ans.size(); 
    } 
};
