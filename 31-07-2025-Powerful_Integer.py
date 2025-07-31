from collections import defaultdict

class Solution:
    def powerfulInteger(self, arr: list[list[int]], k: int) -> int:
        diff = defaultdict(int)

        # Build the difference map
        for start, end in arr:
            diff[start] += 1
            diff[end + 1] -= 1

        active = 0
        ans = -1

        for pos in sorted(diff.keys()):
            delta = diff[pos]
            if active >= k and delta < 0:
                ans = pos - 1
            active += delta

        return ans
