import math

class Solution:

    def rectanglesInCircle(self, r):
        count = 0
        diameter_squared = (2 * r) ** 2

        for length in range(1, 2 * r + 1):
            max_width = int(math.sqrt(diameter_squared - length ** 2))
            
            count += max_width
        
        return count
