class Solution {
    public String matrixChainOrder(int[] arr) {
        int n = arr.length;
        Pair[][] dp = new Pair[n][n];

        for(int i = 0; i < n; i++){
            dp[i][i] = new Pair("" + (char)('A' + i), 0);
        }

        for(int len = 2; len < n; len++){
            for(int i = 0; i < n - len; i++){
                int j = i + len - 1;
                int cost = Integer.MAX_VALUE;
                String best = "";

                for(int k = i + 1; k <= j; k++){
                    int curr = dp[i][k - 1].cost + dp[k][j].cost + arr[i] * arr[k] * arr[j + 1];
                    if(curr < cost){
                        cost = curr;
                        best = "(" + dp[i][k - 1].str + dp[k][j].str + ")";
                    }
                }
                dp[i][j] = new Pair(best, cost);
            }
        }
        return dp[0][n - 2].str;
    }

    // Helper class for storing string + cost
    class Pair {
        String str;
        int cost;

        Pair(String s, int c){
            this.str = s;
            this.cost = c;
        }
    }
}
