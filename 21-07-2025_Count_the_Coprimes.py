import math

class Solution:
    def _mobius_sieve(self, n):
        mu = [0] * (n + 1)
        lp = [0] * (n + 1)
        primes = []

        mu[1] = 1
        for i in range(2, n + 1):
            if lp[i] == 0:  
                lp[i] = i
                primes.append(i)
                mu[i] = -1
            for p in primes:
                if p > lp[i] or i * p > n:
                    break
                lp[i * p] = p
                if p == lp[i]: 
                    mu[i * p] = 0
                else:  
                    mu[i * p] = -mu[i]
        return mu

    def cntCoprime(self, arr):
        
        n = len(arr)
        if n < 2:
            return 0

        max_val = 0
        if arr:
            max_val = max(arr)

        mu = self._mobius_sieve(max_val)

        freq = [0] * (max_val + 1)
        for x in arr:
            freq[x] += 1

        count_multiples = [0] * (max_val + 1)
        for d in range(1, max_val + 1):
            for multiple in range(d, max_val + 1, d):
                count_multiples[d] += freq[multiple]

        total_coprime_pairs = 0
        for d in range(1, max_val + 1):
            if mu[d] == 0:
                continue

            pairs_with_common_divisor_d = count_multiples[d] * (count_multiples[d] - 1) // 2

            total_coprime_pairs += mu[d] * pairs_with_common_divisor_d

        return total_coprime_pairs
       
