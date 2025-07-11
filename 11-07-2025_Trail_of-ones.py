class Solution:
    def countConsec(self, n: int) -> int:
        # code here 
        if n == 0:
            return 0

        a = [0] * (n + 1)  # Ends with 0
        b = [0] * (n + 1)  # Ends with 1

        a[1] = b[1] = 1

        for i in range(2, n + 1):
            a[i] = a[i - 1] + b[i - 1]
            b[i] = a[i - 1]

        total = 2 ** n
        without_consec = a[n] + b[n]
        return total - without_consec
