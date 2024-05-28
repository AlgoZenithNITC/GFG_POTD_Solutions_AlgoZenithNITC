

class Solution {
    public int minimumCost(int n, int w, int[] cost) {
        int[] prev = new int[w + 1];
        int[] curr = new int[w + 1];
        Arrays.fill(prev, (int) 1e8);
        Arrays.fill(curr, (int) 1e8);
        prev[0] = curr[0] = 0;

        for (int i = 1; i <= n; i++) {
            curr[0] = 0;
            for (int k = 0; k <= w; k++) {
                int nontake = prev[k];
                int take = (int) 1e8;
                if (cost[i - 1] != -1 && i <= k) {
                    take = cost[i - 1] + curr[k - i];
                }
                curr[k] = Math.min(take, nontake);
            }
            prev = Arrays.copyOf(curr, curr.length);
        }
        if (prev[w] == (int) 1e8) return -1;
        return prev[w];
    }
}
