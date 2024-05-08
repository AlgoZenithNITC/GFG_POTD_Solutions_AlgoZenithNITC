class Solution {
    public List<List<Integer>> Paths(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(root, curr, ans);
        return ans;
    }

    private void solve(Node root, List<Integer> curr, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        curr.add(root.data);
        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        solve(root.left, curr, ans);
        solve(root.right, curr, ans);
        curr.remove(curr.size() - 1);
    }
}

