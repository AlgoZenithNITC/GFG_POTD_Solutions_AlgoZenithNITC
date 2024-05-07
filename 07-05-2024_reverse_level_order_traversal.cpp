

/*   
struct Node
{
    int data;
    Node* left;
    Node* right;
}; */

void solve(Node* root , vector<int> &ans){
    if(root==NULL) return ;
    queue<Node*> q;
    q.push(root);
    
    while(q.empty()==false){
        int n = q.size();
        for(int i=0;i<n;i++){
            Node* temp = q.front();
            q.pop();
            ans.push_back(temp->data);
            if(temp->right!=NULL) q.push(temp->right);
            if(temp->left!=NULL) q.push(temp->left);
        }
    }
}

vector<int> reverseLevelOrder(Node *root)
{
    // code here
    vector<int> ans ;
    solve(root,ans);
    reverse(ans.begin(),ans.end());
    return ans ;
}
