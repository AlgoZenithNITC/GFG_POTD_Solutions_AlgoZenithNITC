class Solution {
    private:
    void solve(Node* root,map<int,int>&mp,int verticaldis)
    {
        if(root==NULL)
        {
            return;
        }
        mp[verticaldis]=mp[verticaldis]+root->data;
        solve(root->left,mp,verticaldis+1);
        solve(root->right,mp,verticaldis);
    }
  public:
    vector<int> diagonalSum(Node* root) {
        // Add your code here
        map<int,int>mp;
        vector<int>ans;
        int verticaldis=0;
        solve(root,mp,0);
        for(auto it:mp)
        {
            if(it.second>0)
            {
                ans.push_back(it.second);
            }
        }
        return ans;
    }
};
