class Solution:

    def topKSumPairs(self, a, b, k):
        n = len(a)

        # sort both arrays in descending order
        a.sort(reverse=True)
        b.sort(reverse=True)

        visited = set()
        heap = []

        # max-heap to store {sum, {i, j}}
        heapq.heappush(heap, (-(a[0] + b[0]), 0, 0))

        # start from the largest possible pair (0,0)
        visited.add((0, 0))

        res = []

        while len(res) < k:
            sum_neg, i, j = heapq.heappop(heap)
            res.append(-sum_neg)

            # add next element in a if not visited
            if i + 1 < n and (i + 1, j) not in visited:
                heapq.heappush(heap, (-(a[i + 1] + b[j]), i + 1, j))
                visited.add((i + 1, j))

            # add next element in b if not visited
            if j + 1 < n and (i, j + 1) not in visited:
                heapq.heappush(heap, (-(a[i] + b[j + 1]), i, j + 1))
                visited.add((i, j + 1))

        return res