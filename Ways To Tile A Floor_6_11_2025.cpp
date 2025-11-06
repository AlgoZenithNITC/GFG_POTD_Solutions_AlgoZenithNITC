class Solution {
  public:
    int numberOfWays(int n) {
        // code here
        if (n <= 1) return 1;
        
        int prev2 = 1; // f(0)
        int prev1 = 1; // f(1)
        
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
        
    }
};