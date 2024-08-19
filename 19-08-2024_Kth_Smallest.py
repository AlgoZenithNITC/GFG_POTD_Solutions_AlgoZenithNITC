class Solution:
    
    def show(self, arr, i, n):
        l = i * 2 + 1
        r = i * 2 + 2
        max_idx = i

        if r < n:
            if arr[l] > arr[r]:
                max_idx = l
            else:
                max_idx = r
        elif l < n:
            max_idx = l

        if arr[max_idx] > arr[i]:
            arr[i], arr[max_idx] = arr[max_idx], arr[i]
            self.show(arr, max_idx, n)
    
    def kthSmallest(self,arr, l, r, k):
        for i in range((r + 1) // 2 - 1, -1, -1):
            self.show(arr, i, r + 1)

        for i in range(r, k - 1, -1):
            arr[0], arr[i] = arr[i], arr[0]
            self.show(arr, 0, i)

        return arr[0]
