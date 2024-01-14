class Solution:
  def repeatedRows(self, arr, m ,n):
    s = set()
    ans = []
    for i in range(m):
        number = 0
        for j in range(n):
            number += (arr[i][j] << j)
        if number not in s:
            s.add(number)
        else:
            ans.append(i)
    return ans
