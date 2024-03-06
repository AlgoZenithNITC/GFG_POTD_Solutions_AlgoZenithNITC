
class Solution:
    def search(self, pattern, text):
        v = []
        p = len(pattern)
        t = len(text)
        for i in range(t - p + 1):
            if pattern == text[i:i + p]:
                v.append(i + 1)
        return v
