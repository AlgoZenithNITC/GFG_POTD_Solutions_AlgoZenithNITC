import java.util.*;

class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        long[] dp = new long[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            right[stack.pop()] = n;
        }

        dp[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (right[i] == n)
                dp[i] = (long)(n - i) * arr[i];
            else
                dp[i] = (long)(right[i] - i) * arr[i] + dp[right[i]];
        }

        long sum = 0;
        for (long val : dp) {
            sum += val;
        }

        return (int)sum;
    }
}
