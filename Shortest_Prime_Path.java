class Solution{
    int solve(int Num1,int Num2){
        int max_num = 9999;
        int[] prime = new int[10001];
        Arrays.fill(prime, 1);
        prime[1] = 0;
        for (int i = 2; i * i <= max_num; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= max_num; j += i) {
                    prime[j] = 0;
                }
            }
        }

        int[] dp = new int[10001];
        int[] vis = new int[10001];
        Arrays.fill(dp, -1);
        Arrays.fill(vis, 0);
        Queue<Integer> q = new LinkedList<>();
        q.add(Num1);
        dp[Num1] = 0;
        vis[Num1] = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            if (vis[current] == 1) {
                continue;
            }
            vis[current] = 1;
            String s = Integer.toString(current);
            for (int i = 0; i < 4; i++) {
                for (char ch = '0'; ch <= '9'; ch++) {
                    if (ch == s.charAt(i) || (ch == '0' && i == 0)) {
                        continue;
                    }
                    StringBuilder next = new StringBuilder(s);
                    next.setCharAt(i, ch);
                    int next_num = Integer.parseInt(next.toString());
                    if (prime[next_num] == 1 && dp[next_num] == -1) {
                        dp[next_num] = 1 + dp[current];
                        q.add(next_num);
                    }
                    if (next_num == Num2) {
                        return dp[next_num];
                    }
                }
            }
        }
        return dp[Num2];
    }
}
