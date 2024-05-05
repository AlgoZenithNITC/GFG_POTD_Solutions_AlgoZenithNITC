/*Complete the function below
Node is as follows:
struct Node{
int data;
Node *left,*right;
};
*/
class Solution{
  public:
    int offset = 1e4+1;
    void solve(Node* root , int l , map<int,int> &mp){
        if(root==NULL) return ;
        
        solve(root->left,l-1,mp);
        
        if(mp.find(offset+l)==mp.end())
        mp[offset+l]=root->data;
        else
        mp[offset+l]+=root->data;
        
        solve(root->right,l+1,mp);
    }
  
    vector <int> verticalSum(Node *root) {
        // add code here
        map<int,int> mp;
        
        solve(root,0,mp);
        
        vector<int> ans;
        
        for(auto value:mp){
            ans.push_back(value.second);
        }
        
        return ans ;
    }
};
