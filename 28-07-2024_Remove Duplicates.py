class Solution:
	def removeDups(self, s):
		# code here
		seen = set()
        ans = []

        for ch in s:
            if ch not in seen:
                ans.append(ch)
                seen.add(ch)

        return ''.join(ans)
