class Solution:
    def constructList(self, k: int, q: List[List[int]]) -> List[int]:
        ans = [0]
        x = 0
        for op, val in q:
            if op == 0:
                ans.append(val ^ x)
            else:
                x ^= val
        for i in range(len(ans)):
            ans[i] ^= x
        ans.sort()
        return ans

