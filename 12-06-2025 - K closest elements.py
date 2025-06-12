class Solution:

    def printKClosest(self, arr, k, x):
        n = len(arr)
        low, high, pos = 0, n - 1, -1

        # Binary search to find last element less than x
        while low <= high:
            mid = (low + high) // 2
            if arr[mid] < x:
                pos = mid
                low = mid + 1
            else:
                high = mid - 1

        left, right = pos, pos + 1

        # If value at right index is x, increment
        if right < n and arr[right] == x:
            right += 1

        res = []

        while left >= 0 and right < n and len(res) < k:
            leftDiff = abs(arr[left] - x)
            rightDiff = abs(arr[right] - x)

            if leftDiff < rightDiff:
                res.append(arr[left])
                left -= 1
            else:
                res.append(arr[right])
                right += 1

        # If k elements are not filled
        while left >= 0 and len(res) < k:
            res.append(arr[left])
            left -= 1

        while right < n and len(res) < k:
            res.append(arr[right])
            right += 1

        return res
