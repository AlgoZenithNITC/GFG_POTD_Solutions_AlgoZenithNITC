class Solution:
    def minOperations(self, arr):
        total = sum(arr)
        target = total / 2
        curr = total
        count = 0

        # Python has a min-heap by default, so we store negatives for max-heap behavior
        max_heap = [-x for x in arr]
        heapq.heapify(max_heap)

        while curr > target:
            largest = -heapq.heappop(max_heap)  # get the largest element
            half = largest / 2
            curr -= half
            heapq.heappush(max_heap, -half)     # push halved value back
            count += 1

        return count
