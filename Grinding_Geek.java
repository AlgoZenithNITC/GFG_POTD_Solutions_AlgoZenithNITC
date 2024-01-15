class Solution {
    public int max_courses(int n, int total, int[] cost) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= total; j++) {
                row.add(-1);
            }
            dp.add(row);
        }
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j <= total; j++) {
                if (i == n || j == 0) {
                    dp.get(i).set(j, 0);
                } else {
                    dp.get(i).set(j, dp.get(i + 1).get(j));
                    if (j >= cost[i]) {
                        dp.get(i).set(j, Math.max(dp.get(i).get(j), 1 + dp.get(i + 1).get(j - cost[i] + (9 * cost[i] / 10))));
                    }
                }
            }
        }
        return dp.get(0).get(total);
    }
}
