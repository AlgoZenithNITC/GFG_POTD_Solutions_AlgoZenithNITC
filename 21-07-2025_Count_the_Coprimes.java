import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {

    // Helper function to precompute Mobius function using a sieve
    private int[] _mobius_sieve(int n) {
        int[] mu = new int[n + 1];
        int[] lp = new int[n + 1]; // lp[i] stores the smallest prime factor of i
        ArrayList<Integer> primes = new ArrayList<>();

        mu[1] = 1;
        for (int i = 2; i <= n; ++i) {
            if (lp[i] == 0) { // i is prime
                lp[i] = i;
                primes.add(i);
                mu[i] = -1;
            }
            for (int p : primes) {
                if (p > lp[i] || (long)i * p > n) { // Use long to prevent overflow
                    break;
                }
                lp[i * p] = p;
                if (p == lp[i]) { // p divides i^2, so mu(i*p) = 0
                    mu[i * p] = 0;
                } else { // p is a new prime factor, mu(i*p) = -mu(i)
                    mu[i * p] = -mu[i];
                }
            }
        }
        return mu;
    }

    public long cntCoprime(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return 0;
        }

        int max_val = 0;
        if (arr.length > 0) {
            for (int x : arr) {
                if (x > max_val) {
                    max_val = x;
                }
            }
            // Alternative: max_val = Arrays.stream(arr).max().getAsInt();
        }

        int[] mu = _mobius_sieve(max_val);

        int[] freq = new int[max_val + 1];
        for (int x : arr) {
            freq[x]++;
        }

        long[] count_multiples = new long[max_val + 1];
        for (int d = 1; d <= max_val; ++d) {
            for (int multiple = d; multiple <= max_val; multiple += d) {
                count_multiples[d] += freq[multiple];
            }
        }

        long total_coprime_pairs = 0;
        for (int d = 1; d <= max_val; ++d) {
            if (mu[d] == 0) {
                continue;
            }

            // Number of pairs (x, y) where both x and y are multiples of d
            // This is count_multiples[d] choose 2
            long pairs_with_common_divisor_d = count_multiples[d] * (count_multiples[d] - 1) / 2;

            total_coprime_pairs += (long)mu[d] * pairs_with_common_divisor_d;
        }

        return total_coprime_pairs;
    }
}
