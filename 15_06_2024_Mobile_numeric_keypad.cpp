class Solution {
public:
    long long getCount(int n) {
        std::vector<std::vector<int>> mobKeypad = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-1, 0, -1}
        };
        std::unordered_set<long long> seen;

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 3; ++j) {
                solve(mobKeypad, seen, n, 0, 0, i, j);
            }
        }

        return seen.size();
    }

private:
    void solve(const std::vector<std::vector<int>>& mobKeypad, std::unordered_set<long long>& seen, int n, long long res, int count, int i, int j) {
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
            seen.insert(res);
        }

        solve(mobKeypad, seen, n, res, count, i - 1, j);
        solve(mobKeypad, seen, n, res, count, i + 1, j);
        solve(mobKeypad, seen, n, res, count, i, j - 1);
        solve(mobKeypad, seen, n, res, count, i, j + 1);
        solve(mobKeypad, seen, n, res, count, i, j);
    }
};
