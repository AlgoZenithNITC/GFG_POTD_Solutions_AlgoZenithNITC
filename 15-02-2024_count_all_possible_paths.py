class Solution:
    def isPossible(self, paths):
        for path in paths:
            total_sum = sum(path)
            if total_sum % 2 != 0:
                return 0
        return 1
