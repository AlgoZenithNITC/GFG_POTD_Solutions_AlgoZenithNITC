class Solution {
    long floorSqrt(long n) {
        long ans = 0, left = 1, right = n;
        while(left <= right){
            long mid = left + (right - left)/2;
            if(mid * mid == n){
                return mid;
            }
            else if(mid * mid < n){
                left = mid + 1;
                ans = mid;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }
}
