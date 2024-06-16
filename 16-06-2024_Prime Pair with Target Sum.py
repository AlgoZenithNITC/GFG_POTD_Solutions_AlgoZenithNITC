class Solution:
    def isPrime(self, num):
        if num <= 1:
            return False
        if num <= 3:
            return True
        if num % 2 == 0 or num % 3 == 0:
            return False
        i = 5
        while i * i <= num:
            if num % i == 0 or num % (i + 2) == 0:
                return False
            i += 6
        return True

    def getPrimes(self, n):
        for a in range(2, n // 2 + 1):
            b = n - a
            if self.isPrime(a) and self.isPrime(b):
                return [a, b]
        return [-1, -1]
