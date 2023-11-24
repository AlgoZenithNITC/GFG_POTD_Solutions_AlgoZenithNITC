class Solution:
    def shuffleArray(self, arr, n):
        m = n//2
        for i in range(m):
            arr[i + m] += arr[i]*1001
        for i in range(m):
            arr[2*i] = arr[i + m]//1001
            arr[2*i + 1] = arr[i + m]%1001
