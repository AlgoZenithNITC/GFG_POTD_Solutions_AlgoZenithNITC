import java.util.*;

class Solution {
    public int maxKPower(int n, int k) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        Map<Integer, Integer> primesForK = new HashMap<>();
        int ans = (int) 1e9;

        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }

        for (int i = 2; i <= k; i++) {
            if (!isPrime[i]) continue;
            int expo = 0;
            while (k % i == 0) {
                k /= i;
                expo++;
            }
            if (expo > 0)
                primesForK.put(i, expo);
        }

        for (Map.Entry<Integer, Integer> entry : primesForK.entrySet()) {
            int prime = entry.getKey();
            int freq = entry.getValue();
            int cnt = 0;
            long power = prime;
            while (power <= n) {
                cnt += n / power;
                power *= prime;
            }
            ans = Math.min(ans, cnt / freq);
        }

        return ans;
    }
}
