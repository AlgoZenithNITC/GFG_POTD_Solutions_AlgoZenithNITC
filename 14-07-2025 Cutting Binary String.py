class Solution:

    def cuts(self, s):
        if s[0] == '0':
            return -1

        n = len(s)
        maxi = n + 1
        powersOf5 = set()

        # store power of 5
        val = 1
        while val <= 1e9:
            powersOf5.add(val)
            val *= 5

        dp = [maxi] * (n + 1)

        # base case empty suffix requires 0 cuts
        dp[n] = 0

        for i in range(n - 1, -1, -1):

            # ensure there is no leading '0'
            if s[i] == '0':
                continue

            num = 0
            for j in range(i, n):
                num = num * 2 + (1 if s[j] == '1' else 0)

                # and the number is a power of 5
                if num in powersOf5:
                    if dp[j + 1] != maxi:
                        dp[i] = min(dp[i], 1 + dp[j + 1])

        return -1 if dp[0] >= maxi else dp[0]
