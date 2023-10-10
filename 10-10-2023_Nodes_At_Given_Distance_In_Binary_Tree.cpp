class Solution{
public:
    unordered_map<Node*, Node*> parents;
    Node* target_node;
    void parent_finder(Node* root, Node* parent){
        if(!root){
            return;
        }
        parents[root] = parent;
        parent_finder(root -> left, root);
        parent_finder(root -> right, root);
    }
    void find(Node* root, int target, bool &status){
        if(!root){
            return;
        }
        if(root -> data == target and status == false){
            target_node = root;
            status = true;
            return;
        }
        find(root -> left, target, status);
        find(root -> right, target, status);
    }
    vector <int> KDistanceNodes(Node* root, int target , int k){
        parent_finder(root, NULL);
        queue<pair<Node*, int>> q;
        bool status = false;
        find(root, target, status);
        q.push({target_node, k});
        unordered_map<Node*, bool> visited;
        vector<int> ans;
        visited[target_node] = true;
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node* present = q.front().first;
                int position = q.front().second;
                q.pop();
                if(position == 0){
                    ans.push_back(present -> data);
                }
                if(present -> left and position > 0 and visited[present -> left] == false){
                    q.push({present -> left, position - 1});
                    visited[present -> left] = true;
                }
                if(present -> right and position > 0 and visited[present -> right] == false){
                    q.push({present -> right, position - 1});
                    visited[present -> right] = true;
                }
                if(parents[present] and position > 0 and visited[parents[present]] == false){
                    q.push({parents[present], position - 1});
                    visited[parents[present]] = true;
                }
            }
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};
