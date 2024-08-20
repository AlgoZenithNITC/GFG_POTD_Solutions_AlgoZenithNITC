//User function Template for C++

/*
struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/
class Solution {
  public:
    pair<bool,int> get_time(Node* root, int &target, int &ans){
        if(!root){
            return {false, 0};
        }
        pair<bool,int>left = get_time(root->left, target, ans), right = get_time(root->right, target, ans);
        if(!left.first && !right.first){
            ans = max({ans, left.second, right.second});
            int val = max(left.second, right.second);
            if(root->data == target){
                return {true, 1};
            }
            return {false, 1+val};
        }
        else{
            ans = max(ans, left.second + right.second);
            if(left.first){
                return {true, 1+left.second};
            }
            else{
                return {true, 1+right.second};
            }
        }
    }
    int minTime(Node* root, int target) 
    {
        // Your code goes here
        int ans = 0;
        get_time(root, target, ans);
        return ans;
    }
};
