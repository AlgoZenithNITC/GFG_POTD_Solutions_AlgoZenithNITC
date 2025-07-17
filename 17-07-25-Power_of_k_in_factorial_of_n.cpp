class Solution {
  public:
    int maxKPower(int n, int k) {
        vector<bool> isPrime(n + 1, true);
        unordered_map<int, int> primesforK;
        int ans = 1e9;
    
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }
    
        for (int i = 2; i <= k; i++) {
            if (!isPrime[i]) continue;
            int expo = 0;
            while (k % i == 0) {
                k /= i;
                expo++;
            }
            if (expo > 0)
                primesforK[i] = expo;
        }
    
        for (auto& p : primesforK) {
            int prime = p.first;
            int freq = p.second;
            int cnt = 0;
            for (long long power = prime; power <= n; power *= prime)
                cnt += n / power;
    
            ans = min(ans, cnt / freq);
        }
    
        return ans;
    }
};