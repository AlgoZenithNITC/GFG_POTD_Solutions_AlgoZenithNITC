class Solution():

    def isPossible(self, arr, k, w, maxHeight):

        n = len(arr)
        water = [0] * n

        for i in range(n):

            # Add previous watering effect
            if i > 0:
                water[i] = water[i - 1]

            currHeight = arr[i] + water[i]

            # Remove watering effect beyond window w
            if i >= w:
                currHeight -= water[i - w]

            # If current height is less than required
            if currHeight < maxHeight:
                add = maxHeight - currHeight
                water[i] += add
                k -= add

                # If days become negative, not possible
                if k < 0:
                    return False

        return True

    def maxMinHeight(self, arr, k, w):
        n = len(arr)

        # Find minimum height manually
        low = arr[0]
        for i in range(1, n):
            if arr[i] < low:
                low = arr[i]

        high = low + k
        ans = low

        # Binary Search on the answer
        while low <= high:
            mid = low + (high - low) // 2

            if self.isPossible(arr, k, w, mid):
                ans = max(ans, mid)
                low = mid + 1
            else:
                high = mid - 1

        return ans
