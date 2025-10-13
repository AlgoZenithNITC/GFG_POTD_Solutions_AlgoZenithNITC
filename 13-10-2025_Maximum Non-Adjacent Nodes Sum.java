class Pair {
    int include, exclude;
    Pair(int include, int exclude) {
        this.include = include;
        this.exclude = exclude;
    }
}

class Solution {
         static Pair solve(Node root) {
        if (root == null) return new Pair(0, 0);

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        int include = root.data + left.exclude + right.exclude;
        int exclude = Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude);

        return new Pair(include, exclude);
    }

    static int getMaxSum(Node root) {
        Pair ans = solve(root);
        return Math.max(ans.include, ans.exclude);
    }
}