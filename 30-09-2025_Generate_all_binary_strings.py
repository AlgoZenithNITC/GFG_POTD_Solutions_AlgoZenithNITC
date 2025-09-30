class Solution:
    def f(self, s, result, n):
        if len(s) == n:
            result.append(s)
            return
        self.f(s + "0", result, n)
        self.f(s + "1", result, n)

    def binstr(self, n):
        result = []
        self.f("", result, n)
        return result
