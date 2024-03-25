class Solution:
    
    def generate(self, number, ones, zeroes, n, ans):
        if len(number) == n:
            ans.append(number)
            return
        
        self.generate(number + "1", ones + 1, zeroes, n, ans)
        
        if ones > zeroes:
            self.generate(number + "0", ones, zeroes + 1, n, ans)
    
	def NBitBinary(self, n):
		# code here
		ans = []
		s = ""
		self.generate(s, 0, 0, n, ans)
		return ans
