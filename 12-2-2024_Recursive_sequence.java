class Solution{

 public long sequence(int n) {

    long i = 1, k, c = 1, s = 1;
    long p = 0;
    long mod = 1000000007;
    while (i <= n) {
        k = i;
        while (k-- > 0) {
            s = (s * c) % mod;
            c++;
        }

        p = p + s;
        p = p % mod;
        s = 1;
        i++;
    }
    return p;
}

}