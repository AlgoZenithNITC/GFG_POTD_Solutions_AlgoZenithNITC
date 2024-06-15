class Solution:
    def getCount(self, n):
        mobKeypad = [[1, 2, 3], [4, 5, 6], [7, 8, 9], [None, 0, None]]
        seen = set()

        def solve(i, j, res, count):
            # Base case: If the current position is out of bounds or contains None, return
            if i < 0 or j < 0 or i > 3 or j > 2 or mobKeypad[i][j] is None:
                return
            
            # Add the current digit to the result if count is less than or equal to N
            if count <= n:
                res = (res * 10) + mobKeypad[i][j]
                count += 1
            else:
                return
            
            # Check if the result is of length N and is not already in the seen set
            if count == n and res not in seen:
                seen.add(res)

            # Explore all possible moves (up, down, left, right, and staying in the same place)
            solve(i - 1, j, res, count)
            solve(i + 1, j, res, count)
            solve(i, j - 1, res, count)
            solve(i, j + 1, res, count)
            solve(i, j, res, count)

        # Iterate through all positions on the keypad and initiate the recursive exploration
        for i in range(4):
            for j in range(3):
                solve(i, j, 0, 0)
        
        # Return the count of unique results
        return len(seen)
