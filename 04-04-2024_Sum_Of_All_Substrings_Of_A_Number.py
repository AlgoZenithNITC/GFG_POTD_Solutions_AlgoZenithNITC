class Solution:
    def sumSubstrings(self, s: str) -> int:
        MOD = 10**9 + 7
        n = len(s)
        total_sum = int(s[0])
        current_value = int(s[0])
        
        for i in range(1, n):
            current_value = (current_value * 10 + int(s[i]) * (i + 1)) % MOD
            total_sum = (total_sum + current_value) % MOD
        
        return total_sum
