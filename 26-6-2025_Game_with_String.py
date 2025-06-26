import heapq
from collections import Counter

class Solution:
    def minValue(self, s: str, k: int) -> int:
        # Count frequency of each character
        freq = Counter(s)
        
        # Max heap by pushing negative values
        max_heap = [-val for val in freq.values()]
        heapq.heapify(max_heap)

        # Reduce the highest frequency k times
        while k > 0 and max_heap:
            top = -heapq.heappop(max_heap)
            top -= 1
            k -= 1
            if top > 0:
                heapq.heappush(max_heap, -top)
        
        # Compute sum of squares of remaining frequencies
        return sum((-x) * (-x) for x in max_heap)
