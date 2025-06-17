class Solution:

    def minimumCoins(self, arr, k):
        n = len(arr)
        arr.sort()

        total = sum(arr)
        min_removed = total
        window_sum = 0
        prefix = 0
        end = 0

        for start in range(n):
            # Expand the window to include elements
            # within k difference from arr[start]
            while end < n and arr[end] - arr[start] <= k:
                window_sum += arr[end]
                end += 1

            # Calculate the upper limit allowed
            # for pile values in the window
            upper = arr[start] + k
            right_count = n - end

            # Calculate how many coins need
            # to be removed from right-side piles
            remove_right = (total - prefix - window_sum) - right_count * upper
            removed = prefix + remove_right
            min_removed = min(min_removed, removed)

            if end == start:
                end += 1
            else:
                window_sum -= arr[start]

            prefix += arr[start]

        return min_removed
