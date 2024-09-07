#User function Template for python3
class Solution:
    def findNth(self, n):
        # code here
        if n < 9:
            return n
        
        temp = []
        
        while n >= 9:
            remainder = n % 9
            temp.append(remainder)
            n //= 9
            if n < 9:
                temp.append(n)
        
        ans = 0
        for i in range(len(temp) - 1, -1, -1):
            ans = ans * 10 + temp[i]
        
        return ans
