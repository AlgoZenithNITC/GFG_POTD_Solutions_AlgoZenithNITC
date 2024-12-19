class Solution:
  def kthMissing(self,arr, k):
    lo = 0
    hi = len(arr) - 1
    res = len(arr) + k

    while lo <= hi:
        mid = (lo + hi) // 2
        if arr[mid] > mid + k:
            res = mid + k
            hi = mid - 1
        else:
            lo = mid + 1

    return res
