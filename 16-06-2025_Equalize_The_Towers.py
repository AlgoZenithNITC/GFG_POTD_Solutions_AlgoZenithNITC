class Solution:
    def minCost(self, heights, cost):
        def get_total_cost(target):
            total = 0
            for h, c in zip(heights, cost):
                total += abs(h - target) * c
            return total

        low = min(heights)
        high = max(heights)

        # Binary search on the target height
        while low < high:
            mid = (low + high) // 2
            cost1 = get_total_cost(mid)
            cost2 = get_total_cost(mid + 1)

            if cost1 < cost2:
                high = mid
            else:
                low = mid + 1

        return get_total_cost(low)
