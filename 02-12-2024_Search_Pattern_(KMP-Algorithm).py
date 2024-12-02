class Solution:
    def computePrefix(self, pat):
        n = len(pat)
        k = 0
        i = 1
        pre = [0] * n
        while i < n:
            if pat[i] == pat[k]:
                k += 1
                pre[i] = k
                i += 1
            else:
                if k != 0:
                    k = pre[k - 1]
                else:
                    pre[i] = 0
                    i += 1
        return pre

    def search(self, pat, txt):
        n = len(txt)
        m = len(pat)
        i = 0
        j = 0
        pre = self.computePrefix(pat)
        ans = []
        while i < n:
            if txt[i] == pat[j]:
                i += 1
                j += 1
                if j == m:
                    ans.append(i - j)
                    j = pre[j - 1]
            else:
                if j != 0:
                    j = pre[j - 1]
                else:
                    i += 1
        return ans
