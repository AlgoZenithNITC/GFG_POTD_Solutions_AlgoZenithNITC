class Solution{
    public:
    long long mod = 1e9 + 7;
    long long binary_exponent(long long base, long long exponent){
        long long ans = 1;
        while(exponent > 0){
            if(exponent&1){
                ans = (ans*base)%mod;
            }
            base = (base*base)%mod;
            exponent >>= 1;
        }
        return ans;
    }
    long long  numberOfPaths(int rows, int cols){
        long long n = rows + cols - 2;
        long long r = min(rows - 1, cols - 1);
        long long numerator = 1, denominator = 1;
        for(long long i = 0; i < r; i++){
            numerator = (numerator*(n - i))%mod;
            denominator = (denominator*(i + 1))%mod;
        }
        long long MMI_B = binary_exponent(denominator%mod, mod - 2);
        return (numerator*MMI_B)%mod;
    }
};
