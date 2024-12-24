class Solution:

    def searchMatrix(self, mat, x):
        n = len(mat)  
        m = len(mat[0]) 

        left, right = 0, n * m - 1

        while left <= right:
            mid = left + (right - left) // 2
            mid_value = mat[mid // m][mid % m]  

            if mid_value == x:
                return 1  
            elif mid_value < x:
                left = mid + 1 
            else:
                right = mid - 1

        return 0  
