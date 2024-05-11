from math import sqrt


class Solution:

    def jugglerSequence(self, n):
        # Initializing the result list with the initial number
        res = [n]

        # Loop until the number becomes 1
        while n > 1:
            # If the number is odd, perform the juggler equation
            if n % 2:
                n = int(sqrt(n) * n)
            # If the number is even, perform the juggler equation
            else:
                n = int(sqrt(n))

            # Add the number to the result list
            res.append(n)

        # Return the final result list
        return res
