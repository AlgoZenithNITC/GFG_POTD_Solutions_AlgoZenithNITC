class Solution:
    def hIndex(self, citations: list[int]) -> int:
        def check(arr, H):
            count = 0
            for x in arr:
                if x >= H:
                    count += 1
            return count >= H

        low, high = 1, max(citations) if citations else 0

        while low <= high:
            mid = low + (high - low) // 2
            if check(citations, mid):
                low = mid + 1
            else:
                high = mid - 1

        return high
