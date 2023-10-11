class Solution {
  public:
    /*This function returns true if the tree contains 
    a duplicate subtree of size 2 or more else returns false*/
    string structure(unordered_map<string, int> &mp, Node* root){
        if(root == NULL){
            return "";
        }
        string path = structure(mp, root -> left) + to_string(root -> data) + structure(mp, root -> right);
        mp[path]++;
        return path;
    }
    int dupSub(Node *root){
        unordered_map<string, int> mp;
        string result = structure(mp, root);
        for(auto it : mp){
            if(it.first.length() > 2 and it.second > 1){
                return 1;
            }
        }
        return 0;
    }
};
