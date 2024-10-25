class Solution:
    def alternateSort(self, arr):
        arr.sort()
        n = len(arr)
        
        l, r = 0, n - 1
        ans = []
        flag = True
        
        for i in range(n):
            if flag:
                ans.append(arr[r])
                r -= 1
            else:
                ans.append(arr[l])
                l += 1
            flag = not flag
        
        return ans
