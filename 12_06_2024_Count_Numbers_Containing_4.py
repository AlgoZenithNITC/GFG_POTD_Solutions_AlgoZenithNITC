class Solution:
    def countNumberswith4(self, n : int) -> int:
        return sum('4' in str(i) for i in range(1, n+1))  

