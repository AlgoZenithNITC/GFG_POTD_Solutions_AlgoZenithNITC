class Solution:
  
    def max_Books(self, n, k, arr):
        a = 0
        max_books = 0
        for i in range(n):
            if arr[i] <= k:
                a += arr[i]
            else:
                a = 0
            max_books = max(max_books, a)
        return max_books
