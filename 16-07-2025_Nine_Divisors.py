def countNumbers(self, n: int) -> int:
    import math

    ans = 0
    limit = int(math.sqrt(n))

    # Sieve to store least prime factor
    sieve = [0] * (limit + 1)
    for i in range(2, limit + 1):
        sieve[i] = i
    for i in range(2, int(math.sqrt(limit)) + 1):
        if sieve[i] == i:
            for j in range(i * i, limit + 1, i):
                if sieve[j] == j:
                    sieve[j] = i

    for i in range(2, limit + 1):
        p = sieve[i]
        q = sieve[i // p] if p != 0 else 0

        if p * q == i and q != 1 and p != q and q != 0:
            ans += 1
        elif sieve[i] == i:  # i is prime
            pow_val = 1
            for _ in range(8):
                pow_val *= i
                if pow_val > n:
                    break
            if pow_val <= n:
                ans += 1

    return ans
