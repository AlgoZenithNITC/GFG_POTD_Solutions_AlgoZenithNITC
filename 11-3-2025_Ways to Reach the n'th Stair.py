
class Solution:
    def countWays(self, n):
        # code here
            if n == 0 or n == 1:
                return 1

            return countWays(n - 1) + countWays(n - 2)

    n = 4
    print(countWays(n))