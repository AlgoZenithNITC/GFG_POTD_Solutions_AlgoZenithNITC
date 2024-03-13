# Your task is to complete this function

class Solution:
    def matrixDiagonally(self,mat):
        # code here
     ans = []
     row = 0
     col = 0
     n = len(mat)
     while len(ans) < n * n:
      while row >= 0 and col < n:
        if row >= 0 and col >= 0 and row < n and col < n:
            ans.append(mat[row][col])
            mat[row][col] = 1e9
        row -= 1
        col += 1
      if len(ans) == n * n:
        break
      row = max(row, 0)
      col = min(col, n - 1)
      while mat[row][col] == 1e9:
        row += 1
      while col >= 0 and row < n:
        if row >= 0 and col >= 0 and row < n and col < n:
            ans.append(mat[row][col])
            mat[row][col] = 1e9
        row += 1
        col -= 1
      if len(ans) == n * n:
         break
      row = min(row, n - 1)
      col = max(col, 0)
      while mat[row][col] == 1e9:
        col += 1
     return ans



#{ 
 # Driver Code Starts
# Driver Program
if __name__=='__main__':
    t = int(input())
    for i in range(t):
        n = list(map(int, input().strip().split()))
        arr = list(map(int, input().strip().split()))
        matrix = [[0 for i in range(n[0])]for j in range(n[0])]
        k=0
        for i in range(n[0]):
            for j in range(n[0]):
                matrix[i][j] = arr[k]
                k+=1
        a = Solution().matrixDiagonally(matrix)
        for x in a:
            print(x,end=' ')
        print('')
# Contributed by: Harshit Sidhwa
# } Driver Code Ends