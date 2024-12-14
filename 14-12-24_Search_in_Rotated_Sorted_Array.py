class Solution:
    def search(self, arr, key):
        l, r = 0, len(arr) - 1
        while l <= r:
            m = (l + r) // 2
            if arr[m] == key:
                return m
            if arr[m] > key:
                if arr[l] > key and arr[l] <= arr[m]:
                    l = m + 1
                else:
                    r = m - 1
            else:
                if arr[r] < key and arr[m] <= arr[r]:
                    r = m - 1
                else:
                    l = m + 1
        return -1
