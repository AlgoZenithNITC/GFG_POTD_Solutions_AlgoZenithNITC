class Solution{
    public:
    vector<vector<int>> paths;
    void findPaths(vector<int> path, Node *root, int curr_sum, int target){
        if(!root){
            return;
        }
        curr_sum += root -> key; //consideration
        path.push_back(root -> key); //consideration
        if(curr_sum == target){
            paths.push_back(path); //push it into 2d vector
        }
        findPaths(path, root -> left, curr_sum, target); //left
        findPaths(path, root -> right, curr_sum, target); //right
        path.pop_back(); //delete
    }
    vector<vector<int>> printPaths(Node *root, int sum){
        vector<int> path; //1d vector of path
        findPaths(path, root, 0, sum);
        return paths;
    }
};
