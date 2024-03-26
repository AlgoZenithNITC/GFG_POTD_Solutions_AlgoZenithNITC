class Solution:
    def isAdditiveSequence(self, str):
        n = len(str)
        if n < 3:
            return False
        ans, s1 = "", ""
        for i in range(min(n-1, 10)):
            s1 += str[i]
            s2 = ""
            for j in range(i+1, min(n, 10)):
                s2 += str[j]
                ans = s1 + s2
                a = int(s1)
                b = int(s2)
                while len(ans) < n:
                    sum = a + b
                    s = str(sum)
                    if n - len(ans) < len(s):
                        break
                    ans += s
                    a = b
                    b = sum
                    if ans == str:
                        return True
        return False

