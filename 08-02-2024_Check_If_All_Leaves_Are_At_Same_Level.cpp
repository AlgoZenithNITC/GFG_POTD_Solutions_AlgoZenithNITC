class Solution{
  public:
    bool check(Node *root)
    {
        set<int>st;
        queue<Node*>q;
        q.push(root);
        int level=0;
        while(!q.empty()){
            int n=q.size();
            while(n--){
                auto front=q.front();
                q.pop();
                if(!front->left && !front->right) st.insert(level);
                if(front->left) q.push(front->left);
                if(front->right) q.push(front->right);
            }
            level++;
        }
        return st.size()==1;
    }
};
