class Solution:
    
    def countPS(self, s):
        def expand_around_center(left, right):
            count = 0
            while left >= 0 and right < len(s) and s[left] == s[right]:
                if right - left + 1 >= 2:
                    count += 1
                left -= 1
                right += 1
            return count
    
        n = len(s)
        count = 0
    
        for i in range(n):
            count += expand_around_center(i, i)      # Odd-length palindromes
            count += expand_around_center(i, i + 1)  # Even-length palindromes
    
        return count
