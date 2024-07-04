class Solution {
    public ArrayList<Node> printAllDups(Node root) {
        HashMap<String, Integer> mp = new HashMap<>();
        ArrayList<Node> ans = new ArrayList<>();
        solve(root, mp, ans);
        return ans;
    }

    private String solve(Node root, HashMap<String, Integer> mp, ArrayList<Node> ans) {
        if (root == null) {
            return "N";
        }

        String s = Integer.toString(root.data) + "," + solve(root.left, mp, ans)
                + "," + solve(root.right, mp, ans);
        mp.merge(s, 1, Integer::sum);
        if (mp.get(s) == 2) {
            ans.add(root);
        }
        return s;
    }
}

