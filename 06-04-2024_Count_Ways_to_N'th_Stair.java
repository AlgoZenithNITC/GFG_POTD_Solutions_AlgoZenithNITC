class Solution {
    Long countWays(int n) {
        Long res[] = new Long[n + 1];

        res[0] = 1L;
        res[1] = 1L;

        for (int i = 2; i <= n; i++) res[i] = (res[i - 2] + 1);

        return res[n];
    }
}
