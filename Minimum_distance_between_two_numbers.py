class Solution:
    def minDist(self, a, n, x, y):
        ans = 1000000;
        left = -1
        right = -1
        for i in range(len(a)):
            if a[i] == x:
                left = i
            if a[i] == y:
                right = i
            if left != -1 and right != -1:
                ans = min(ans, abs(left - right))
        return -1 if ans == 1000000 else ans
