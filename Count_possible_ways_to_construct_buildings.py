class Solution:
	def TotalWays(self, N):
		if N == 1:
		    return 4
		if N == 2:
		    return 9
		mod = 1000000007
		previous_two = 2
		previous_one = 3
		present = 0
		for i in range(3, N + 1):
		    present = (previous_one + previous_two + mod) % mod
		    previous_two = previous_one
		    previous_one = present
		total = ((present % mod) * (present % mod)) % mod
		return total
