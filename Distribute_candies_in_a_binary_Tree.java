class Solution{
    static int ans;
    static int solve(Node root){
        if(root == null){
            return 0;
        }
        int left_profit = solve(root.left);
        int right_profit = solve(root.right);
        ans += Math.abs(left_profit) + Math.abs(right_profit);
        return root.data + left_profit + right_profit - 1;
    }
    public static int distributeCandy(Node root){
        ans = 0;
        solve(root);
        return ans;
    }
}
