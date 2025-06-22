import java.util.*;

class Solution {
    public List<Integer> largestSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxSize = 1, maxIdx = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] % arr[i] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    } else if (dp[j] + 1 == dp[i] && (parent[i] == -1 || arr[j] > arr[parent[i]])) {
                        parent[i] = j;
                    }
                }
            }

            if (dp[i] > maxSize || (dp[i] == maxSize && arr[i] > arr[maxIdx])) {
                maxSize = dp[i];
                maxIdx = i;
            }
        }

        List<Integer> subset = new ArrayList<>();
        int curr = maxIdx;
        while (curr != -1) {
            subset.add(arr[curr]);
            curr = parent[curr];
        }

        return subset;
    }
}
