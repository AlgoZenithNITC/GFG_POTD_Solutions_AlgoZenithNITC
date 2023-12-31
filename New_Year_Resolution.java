class Solution{
    boolean isPossible(int N, int[] coins){
    int total = Arrays.stream(coins).sum();
    boolean[][] possibility = new boolean[N + 1][total + 1];
    for (int i = 0; i <= N; i++) {
        possibility[i][0] = true;
    }
    for (int i = 1; i <= total; i++) {
        possibility[0][i] = false;
    }
    for (int idx = 1; idx <= N; idx++) {
        for (int sum = 1; sum <= total; sum++) {
            if (sum < coins[idx - 1]) {
                possibility[idx][sum] = possibility[idx - 1][sum];
            }
            if (sum >= coins[idx - 1]) {
                possibility[idx][sum] = possibility[idx - 1][sum] || possibility[idx - 1][sum - coins[idx - 1]];
            }
        }
    }
    for (int sum = 1; sum <= total; sum++) {
        if ((sum % 20 == 0 || sum % 24 == 0 || sum == 2024) && possibility[N][sum]) {
            return true;
        }
    }
    return false;
}
}
