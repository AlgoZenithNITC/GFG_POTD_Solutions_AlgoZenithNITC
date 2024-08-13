class Solution:
    def floorSqrt(self, n):
        ans = 0
        left = 1
        right = n
        while left <= right:
            mid = left + (right - left)//2;
            if mid * mid == n:
                return mid
            
            elif mid*mid < n:
                left = mid + 1
                ans = mid
            
            else:
                right = mid - 1
            
        return ans
