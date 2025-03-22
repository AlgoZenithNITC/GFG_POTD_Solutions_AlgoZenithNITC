class Solution:
    def find(self, arr, i, n):
        return sum(arr[j] for j in range(i, n, 2))

    def maxValue(self, arr):
        n = len(arr)
        w1 = self.find(arr, 0, n - 1)
        w2 = self.find(arr, 1, n)
        return max(w1, w2)


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        ob = Solution()
        res = ob.maxValue(arr)
        print(res)
        print("~")
