class Solution {
  public:
    vector <int> bottomView(Node *root) {
        queue<Node*> q;
        vector<int>ans;
        if(root == NULL) return ans;
        int hd = 0;
        q.push(root);
        map<int,int> mp;
        map<Node*, int> mn;
        mn[root] = hd;
        
        while(!q.empty()){
            Node* temp = q.front();
            q.pop();
            hd = mn[temp];
            
            mp[hd] = temp->data;
            
            if(temp->left){
                mn[temp->left] = hd-1;
                q.push(temp->left);
            }
            if(temp->right){
                mn[temp->right] = hd+1;
                q.push(temp->right);
            }
            
        }
        
        for(auto i = mp.begin(); i != mp.end(); i++){
            ans.push_back(i->second);
        }
        return ans;
    }
};
