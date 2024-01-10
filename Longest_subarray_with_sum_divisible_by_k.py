class Solution:
	def longSubarrWthSumDivByK(self, arr, n, k): 
	  ans = 0 
		mp = {}
		rem = 0
		for i in range(n):
		    rem = (rem + arr[i]%k + k)%k
		    if rem == 0:
		        ans = max(ans, i + 1)
		    elif rem not in mp:
		        mp[rem] = i
		    else:
		        ans = max(ans, i - mp[rem])
		return ans
