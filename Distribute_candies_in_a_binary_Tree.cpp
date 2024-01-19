class Solution{
    public:
    int ans = 0;
    int solve(Node* root){
        if(!root){
            return 0;
        }
        int left_profit = solve(root -> left);
        int right_profit = solve(root -> right);
        ans += abs(left_profit) + abs(right_profit); //transactions
        return root -> key + left_profit + right_profit - 1; //profit
    }
    int distributeCandy(Node* root){
        solve(root);
        return ans;
    }
};
