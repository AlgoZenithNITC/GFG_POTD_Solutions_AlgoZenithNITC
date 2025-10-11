class Solution {
    private int helper(Node root, int[] ans) {
        if (root == null) return 0;
        
        int left = helper(root.left, ans);
        int right = helper(root.right, ans);
        
        int val = root.data + Math.max(left, 0) + Math.max(right, 0);
        ans[0] = Math.max(ans[0], val);
        
        return root.data + Math.max(Math.max(left, right), 0);
    }
    
    public int findMaxSum(Node root) {
        int[] ans = {Integer.MIN_VALUE};
        helper(root, ans);
        return ans[0];
    }
}
