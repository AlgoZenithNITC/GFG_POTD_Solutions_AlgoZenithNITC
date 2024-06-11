class Solution:
    def maxTip(self, n: int, x: int, y: int, arr: List[int], brr: List[int]) -> int:
        dp = sorted([(abs(a - b), (a, b)) for a, b in zip(arr, brr)], reverse=True)
        ans = 0
        while x > 0 or y > 0:
            a, b = dp.pop(0)
            if x == 0:
                ans += b[1]
            elif y == 0:
                ans += b[0]
            else:
                if b[0] > b[1]:
                    x -= 1
                    ans += b[0]
                else:
                    y -= 1
                    ans += b[1]
        return ans

