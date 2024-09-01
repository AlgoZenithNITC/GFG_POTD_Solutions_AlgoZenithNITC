class Solution:
    def maxPathSum(self, ar1, ar2):
        m, n = len(ar1), len(ar2)
        i, j = 0, 0
    
        result, sum1, sum2 = 0, 0, 0
        
        while i < m and j < n:
            if ar1[i] < ar2[j]:
                sum1 += ar1[i]
                i += 1
            elif ar1[i] > ar2[j]:
                sum2 += ar2[j]
                j += 1
            else:
                result += max(sum1, sum2) + ar1[i]
                sum1, sum2 = 0, 0
                i += 1
                j += 1
        
        while i < m:
            sum1 += ar1[i]
            i += 1
        
        while j < n:
            sum2 += ar2[j]
            j += 1
        
        result += max(sum1, sum2)
        
        return result
