class Solution {
    public:
    int mod = 1e9 + 7;
    int padovanSequence(int n) {
        int curr = 1, next = 1, prev2 = 1, prev = 1;
        for(int i = 3; i <= n; i++){
            next = (prev2 % mod + prev % mod) % mod;
            prev2 = prev % mod;
            prev = curr % mod;
            curr = next % mod;
        }
        return next % mod;
    }
};
