class Solution:
	def countStrings(self,n):
    	prev_zero = 1
    	prev_one = 1
    	curr_zero = 1
    	curr_one = 1
    	mod = int(1e9) + 7
    	for i in range(2, n+1):
    	    curr_zero = (prev_zero + prev_one)%mod
    	    curr_one = prev_zero%mod
    	    prev_zero = curr_zero
    	    prev_one = curr_one
        return (curr_one + curr_zero)%mod
