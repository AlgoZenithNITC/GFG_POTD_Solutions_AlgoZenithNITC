class Solution:

    def minCost(self, height):
        n = len(height)

        if n == 1:
            return 0

        # Variables prev1 and prev2 to store the result
        # of last and second last states
        prev2 = 0
        prev1 = abs(height[1] - height[0])

        for i in range(2, n):
            curr = min(prev1 + abs(height[i] - height[i - 1]),
                       prev2 + abs(height[i] - height[i - 2]))

            # Updating prev2 to previous result and
            # prev1 to current result
            prev2 = prev1
            prev1 = curr

        # In the last iteration, final value
        # of curr is stored in  prev1
        return prev1
