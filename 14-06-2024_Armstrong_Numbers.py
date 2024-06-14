class Solution:
    def armstrongNumber(self, n):
        originalNumber = n
        sumOfCubes = 0

        while n > 0:
            digit = n % 10
            sumOfCubes += digit ** 3
            n //= 10

        if sumOfCubes == originalNumber:
            return "true"
        else:
            return "false"
