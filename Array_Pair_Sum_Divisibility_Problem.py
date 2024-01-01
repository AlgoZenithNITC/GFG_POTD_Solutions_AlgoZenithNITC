class Solution:
	def canPair(self, nuns, k):
		if len(nums) % 2 != 0:
		    return False
		mp = {}
		for i in nums:
		    y = i % k
		    if mp.get((k - y) % k, 0) != 0:
		        mp[(k - y) % k] -= 1
		    else:
                mp[y] = mp.get(y, 0) + 1
        for key, value in mp.items():
            if value != 0:
                return False
        return True
