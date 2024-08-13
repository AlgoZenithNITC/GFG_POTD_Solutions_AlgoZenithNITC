class Solution {
  public:
    long long int floorSqrt(long long int n) {
        if(n == 0 || n == 1) return n;
        
        long long int left = 1, right = n, ans;
        while(left <= right){
            long long int mid = left + (right - left)/2;
            if(mid * mid == n) return mid;
            
            if(mid * mid < n){
                left = mid + 1;
                ans = mid;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }
};
