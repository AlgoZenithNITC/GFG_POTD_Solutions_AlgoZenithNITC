from typing import List
from collections import deque

class Solution:
    def sumSubMins(self, arr: List[int]) -> int:
        n = len(arr)
        dp = [0] * n
        right = [0] * n
        stack = deque()

        for i in range(n):
            while stack and arr[i] < arr[stack[-1]]:
                right[stack[-1]] = i
                stack.pop()
            stack.append(i)

        while stack:
            right[stack[-1]] = n
            stack.pop()

        dp[-1] = arr[-1]
        for i in range(n - 2, -1, -1):
            if right[i] == n:
                dp[i] = (n - i) * arr[i]
            else:
                dp[i] = (right[i] - i) * arr[i] + dp[right[i]]

        return sum(dp)
