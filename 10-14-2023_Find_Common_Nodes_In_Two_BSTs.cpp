class Solution{
    public:
    void root1_nodes(unordered_map<int, int> &mp, Node* root1){
        if(root1 == NULL){
            return; 
        }
        mp[root1 -> data]++;
        root1_nodes(mp, root1 -> left);
        root1_nodes(mp, root1 -> right);
    }
    void root2_nodes(unordered_map<int, int> &mp, Node* root2, vector<int>& ans){
        if(root2 == NULL){
            return;
        }
        root2_nodes(mp, root2 -> left, ans);
        if(mp.find(root2 -> data) != mp.end()){
            ans.push_back(root2 -> data);
        }
        root2_nodes(mp, root2 -> right, ans);
    }
    vector<int> findCommon(Node *root1, Node *root2){
        unordered_map<int, int> mp;
        root1_nodes(mp, root1);
        vector<int> ans;
        root2_nodes(mp, root2, ans);
        return ans;
    }
};
