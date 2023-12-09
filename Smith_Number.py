import math
class Solution:
    def digitsum(self, n):
        ans = 0
        while n:
            ans += n % 10
            n //= 10
        return ans
    def smithNum(self, n):
        sum = 0
        k = n
        temp = self.digitsum(n)
        for i in range(2, int(math.sqrt(n)) + 1):
            while n % i == 0:
                sum += self.digitsum(i)
                n //= i
        if n > 1 and n != k:
            sum += self.digitsum(n)
        return 1 if sum == temp else 0
