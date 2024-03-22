import java.util.*;

class Solution {
    private void solve(Node root, Map<Integer, Integer> mp, int verticaldis) {
        if (root == null) {
            return;
        }
        mp.put(verticaldis, mp.getOrDefault(verticaldis, 0) + root.data);
        solve(root.left, mp, verticaldis + 1);
        solve(root.right, mp, verticaldis);
    }

    public List<Integer> diagonalSum(Node root) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int verticaldis = 0;
        solve(root, mp, 0);
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > 0) {
                ans.add(entry.getValue());
            }
        }
        return ans;
    }
}

