import java.util.HashSet;
import java.util.Set;

class Solution {
    public long getCount(int n) {
        int[][] mobKeypad = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-1, 0, -1}
        };
        Set<Integer> seen = new HashSet<>();

        solve(mobKeypad, seen, n, 0, 0, 0, 0);
        solve(mobKeypad, seen, n, 0, 0, 0, 1);
        solve(mobKeypad, seen, n, 0, 0, 0, 2);
        solve(mobKeypad, seen, n, 0, 0, 1, 0);
        solve(mobKeypad, seen, n, 0, 0, 1, 1);
        solve(mobKeypad, seen, n, 0, 0, 1, 2);
        solve(mobKeypad, seen, n, 0, 0, 2, 0);
        solve(mobKeypad, seen, n, 0, 0, 2, 1);
        solve(mobKeypad, seen, n, 0, 0, 2, 2);
        solve(mobKeypad, seen, n, 0, 0, 3, 1);

        return seen.size();
    }

    private void solve(int[][] mobKeypad, Set<Integer> seen, int n, int res, int count, int i, int j) {
        if (i < 0 || j < 0 || i > 3 || j > 2 || mobKeypad[i][j] == -1) {
            return;
        }

        if (count < n) {
            res = res * 10 + mobKeypad[i][j];
            count++;
        } else {
            return;
        }

        if (count == n) {
            seen.add(res);
        }

        solve(mobKeypad, seen, n, res, count, i - 1, j);
        solve(mobKeypad, seen, n, res, count, i + 1, j);
        solve(mobKeypad, seen, n, res, count, i, j - 1);
        solve(mobKeypad, seen, n, res, count, i, j + 1);
        solve(mobKeypad, seen, n, res, count, i, j);
    }
}
