
class Solution {
  public:
    long long sumMatrix(long long n, long long q) {
        // code here
        if(q>2*n) return 0;
        return n-abs(n+1-q);
    }
};
