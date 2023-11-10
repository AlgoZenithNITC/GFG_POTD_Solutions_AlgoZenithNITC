class Solution:
    def printMinNumberForPattern(ob,s):
        n, current, i = len(s), 1, 0
        ans = ['1']
        while i < n:
            if s[i] == 'D':
                j = i
                while j < n and s[j] == 'D':
                    j += 1
                no_of_D = j - i
                current += no_of_D
                ans[i] = str(current)
                count = current
                while i != j:
                    count -= 1
                    ans.append(str(count))
                    i += 1
            else:
                current += 1
                ans.append(str(current))
                i += 1
