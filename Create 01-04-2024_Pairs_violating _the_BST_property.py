class Solution:
    def merge(self, arr, low, mid, high):
        temp = []
        left = low
        right = mid + 1
        cnt = 0
        
        while left <= mid and right <= high:
            if arr[left] <= arr[right]:
                temp.append(arr[left])
                left += 1
            else:
                temp.append(arr[right])
                cnt += (mid - left + 1)
                right += 1
        
        while left <= mid:
            temp.append(arr[left])
            left += 1
        
        while right <= high:
            temp.append(arr[right])
            right += 1
        
        for i in range(low, high + 1):
            arr[i] = temp[i - low]
        
        return cnt
    
    def mergeSort(self, arr, low, high):
        cnt = 0
        if low >= high:
            return cnt
        mid = (low + high) // 2
        cnt += self.mergeSort(arr, low, mid)
        cnt += self.mergeSort(arr, mid + 1, high)
        cnt += self.merge(arr, low, mid, high)
        return cnt
    
    def numberOfInversions(self, a, n):
        return self.mergeSort(a, 0, n - 1)
    
    def solve(self, inorder, root):
        if root is None:
            return
        self.solve(inorder, root.left)
        inorder.append(root.data)
        self.solve(inorder, root.right)
    
    def pairsViolatingBST(self, n, root):
        inorder = []
        self.solve(inorder, root)
        m = len(inorder)
        ans = 0
        return self.numberOfInversions(inorder, m)

