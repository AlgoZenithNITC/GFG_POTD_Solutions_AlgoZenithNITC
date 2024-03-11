class Solution:
	def countPairs(self, mat1, mat2, n, x):
		# code here
		r1 = 0
		c1 = 0
		r2 = n-1
		c2 = n-1
		count = 0
		while r1 < n and r2 >= 0:
		    val = mat1[r1][c1] + mat2[r2][c2]
		    if val == x:
		        count += 1
		        c1 += 1
		        c2 -= 1
		    elif val < x:
		        c1 += 1
		    else:
		        c2 -= 1
		    if c1 == n:
		        c1 = 0
		        r1 += 1
		    if c2 == -1:
		        c2 = n-1
		        r2 -= 1
        return count
