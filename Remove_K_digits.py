class Solution:
  def removeKdigits(self, S, K):
    n = len(S)
    if n == K:
        return "0"
    store = []
    for i in range(n):
        while K and store and store[-1] > S[i]:
            store.pop()
            K -= 1
        store.append(S[i])
    while K:
        store.pop()
        K -= 1
    ans = ""
    while store:
        ans += store.pop()
    ans = ans[::-1]
    for i in range(len(ans)):
        if ans[i] != '0':
            return ans[i:]
    return "0"
