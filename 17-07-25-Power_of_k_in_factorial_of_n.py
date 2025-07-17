class Solution:
    def maxKPower(self, n: int, k: int) -> int:
        is_prime = [True] * (n + 1)
        primes_for_k = {}
        ans = int(1e9)

        is_prime[0] = is_prime[1] = False
        for i in range(2, int(n**0.5) + 1):
            if is_prime[i]:
                for j in range(i * i, n + 1, i):
                    is_prime[j] = False

        for i in range(2, k + 1):
            if not is_prime[i]:
                continue
            expo = 0
            while k % i == 0:
                k //= i
                expo += 1
            if expo > 0:
                primes_for_k[i] = expo

        for prime, freq in primes_for_k.items():
            cnt = 0
            power = prime
            while power <= n:
                cnt += n // power
                power *= prime
            ans = min(ans, cnt // freq)

        return ans
