#User function Template for python3
class Solution:
    def recamanSequence(self, n):
        ans = [0] * n
        mp = {}
        ans[0] = 0
        for i in range(1, n):
            if ans[i - 1] - i > 0:
                if mp.get(ans[i - 1] - i, 0) == 0:
                    ans[i] = ans[i - 1] - i
                    mp[ans[i]] = 1
                else:
                    ans[i] = ans[i - 1] + i
                    mp[ans[i]] = 1
            else:
                ans[i] = ans[i - 1] + i
                mp[ans[i]] = 1
        return ans

