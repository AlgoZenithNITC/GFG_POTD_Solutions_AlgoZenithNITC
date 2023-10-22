class Solution{
  long mod = 1000000007L;
    long binary_exponent(long base, long exponent){
        long ans = 1;
        while(exponent > 0){
            if((exponent & 1) == 1){
                ans = (ans * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return ans;
    }
    long numberOfPaths(int rows, int cols){
        long n = rows + cols - 2;
        long r = Math.min(rows - 1, cols - 1);
        long numerator = 1, denominator = 1;
        for(long i = 0; i < r; i++){
            numerator = (numerator * (n - i)) % mod;
            denominator = (denominator * (i + 1)) % mod;
        }
        long MMI_B = binary_exponent(denominator % mod, mod - 2);
        return (numerator * MMI_B) % mod;
    }
};
