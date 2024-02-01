class Solution:
    
    def atoi(self, s: str) -> int:
        n = len(s)
        sum_val = 0
        k = 1

        for i in range(n - 1, 0, -1):
            if '0' <= s[i] <= '9':
                temp = int(s[i])
                sum_val += k * temp
                k *= 10
            else:
                return -1

        if s[0] == '+':
            return sum_val
        elif s[0] == '-':
            return 0 - sum_val
        elif '0' <= s[0] <= '9':
            temp = int(s[0])
            sum_val += k * temp
            return sum_val
        else:
            return -1

