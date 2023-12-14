class Solution{
    long countWays(int n,int k){
        long total = k, same = 0, diff = k, mod = (long)1e9 + 7;
        for(int i = 2; i <= n; i++){
            same = diff;
            diff = (total % mod * (k - 1) % mod) % mod;
            total = (same + diff) % mod;
        }
        return total;
    }
}
