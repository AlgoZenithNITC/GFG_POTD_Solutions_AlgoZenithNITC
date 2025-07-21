#include <vector>
#include <numeric> 
#include <algorithm>

class Solution {
public:
    // Helper function to precompute Mobius function using a sieve
    std::vector<int> _mobius_sieve(int n) {
        std::vector<int> mu(n + 1);
        std::vector<int> lp(n + 1, 0); // lp[i] stores the smallest prime factor of i
        std::vector<int> primes;

        mu[1] = 1;
        for (int i = 2; i <= n; ++i) {
            if (lp[i] == 0) { // i is prime
                lp[i] = i;
                primes.push_back(i);
                mu[i] = -1;
            }
            for (int p : primes) {
                if (p > lp[i] || (long long)i * p > n) { // Use long long to prevent overflow
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

    long long cntCoprime(std::vector<int>& arr) {
        int n = arr.size();
        if (n < 2) {
            return 0;
        }

        int max_val = 0;
        if (!arr.empty()) {
            for (int x : arr) {
                if (x > max_val) {
                    max_val = x;
                }
            }
        }

        std::vector<int> mu = _mobius_sieve(max_val);

        std::vector<int> freq(max_val + 1, 0);
        for (int x : arr) {
            freq[x]++;
        }

        std::vector<long long> count_multiples(max_val + 1, 0);
        for (int d = 1; d <= max_val; ++d) {
            for (int multiple = d; multiple <= max_val; multiple += d) {
                count_multiples[d] += freq[multiple];
            }
        }

        long long total_coprime_pairs = 0;
        for (int d = 1; d <= max_val; ++d) {
            if (mu[d] == 0) {
                continue;
            }

            // Number of pairs (x, y) where both x and y are multiples of d
            // This is count_multiples[d] choose 2
            long long pairs_with_common_divisor_d = count_multiples[d] * (count_multiples[d] - 1) / 2;

            total_coprime_pairs += (long long)mu[d] * pairs_with_common_divisor_d;
        }

        return total_coprime_pairs;
    }
};
