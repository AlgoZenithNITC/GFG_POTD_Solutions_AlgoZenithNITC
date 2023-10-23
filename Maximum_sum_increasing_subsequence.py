class Solution:
	def maxSumIS(self, arr, n):
		n = len(arr)
		dp = arr.copy()
		ans = dp[0]
		for i in range(1, n):
		    for j in range(i - 1, -1, -1):
		        if arr[j] < arr[i]:
		            dp[i] = max(dp[i], dp[j] + arr[i])
            ans = max(ans, dp[i])
        return ans
