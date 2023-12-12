class Solution:
  def maxGold(self, n, m, M):
    ans = 0
    for j in range(m - 2, -1, -1):
        for i in range(n):
            if i == 0:
                if i + 1 < n:
                    M[i][j] += max(M[i][j + 1], M[i + 1][j + 1])
                else:
                    M[i][j] += M[i][j + 1]
            elif i == n - 1:
                if i - 1 >= 0:
                    M[i][j] += max(M[i][j + 1], M[i - 1][j + 1])
                else:
                    M[i][j] += M[i][j + 1]
            else:
                temp = M[i][j + 1]
                if i + 1 < n:
                    temp = max(temp, M[i + 1][j + 1])
                if i - 1 >= 0:
                    temp = max(temp, M[i - 1][j + 1])
                M[i][j] += temp
            if j == 0:
                ans = max(M[i][j], ans)
    return ans
