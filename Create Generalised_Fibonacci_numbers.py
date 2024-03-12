
class Solution:
    def multiply(self, a, b, m):
        mul = [[0 for _ in range(3)] for _ in range(3)]
        for i in range(3):
            for j in range(3):
                for k in range(3):
                    mul[i][j] = (mul[i][j] + a[i][k] * b[k][j]) % m
        return mul

    def find(self, arr, n, m):
        temp = [[1, 0, 0], [0, 1, 0], [0, 0, 1]]
        while n > 0:
            if n & 1:
                temp = self.multiply(temp, arr, m)
            arr = self.multiply(arr, arr, m)
            n //= 2
        return temp

    def genFibNum(self, a, b, c, n, m):
        if m == 1:
            return 0
        if n == 1 or n == 2:
            return 1
        
        F = [[a, b, 1], [1, 0, 0], [0, 0, 1]]
        F = self.find(F, n - 2, m)
        return (F[0][0] + F[0][1] + F[0][2] * c) % m
