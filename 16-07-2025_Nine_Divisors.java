public static int countNumbers(int n) {
    int ans = 0;
    int limit = (int)Math.sqrt(n);

    // Sieve to store least prime factor
    int[] sieve = new int[limit + 1];
    for (int i = 2; i <= limit; i++) {
        sieve[i] = i;
    }
    for (int i = 2; i * i <= limit; i++) {
        if (sieve[i] == i) {
            for (int j = i * i; j <= limit; j += i) {
                if (sieve[j] == j) {
                    sieve[j] = i;
                }
            }
        }
    }

    for (int i = 2; i <= limit; i++) {
        int p = sieve[i];
        int q = sieve[i / p];

        if (p * q == i && q != 1 && p != q) {
            ans++;
        } else if (sieve[i] == i) { // i is prime
            long pow = 1;
            for (int k = 0; k < 8; k++) {
                pow *= i;
                if (pow > n) break;
            }
            if (pow <= n) ans++;
        }
    }

    return ans;
}
