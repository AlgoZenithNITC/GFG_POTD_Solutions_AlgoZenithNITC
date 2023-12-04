class Solution:
    def addStrings(self, num1, num2):
        i = len(num1) - 1
        j = len(num2) - 1
        output = []
        carry = 0
        while i >= 0 or j >= 0 or carry > 0:
            sum = carry
            if i >= 0:
                sum += int(num1[i])
                i -= 1
            if j >= 0:
                sum += int(num2[j])
                j -= 1
            rem = sum % 10
            carry = sum // 10
            output.append(str(rem))
        return ''.join(output[::-1])

    def check(self, str, start, len1, len2, n):
        s1 = str[start : start + len1]
        s2 = str[start + len1 : start + len1 + len2]
        s3 = self.addStrings(s1, s2)
        s3_len = len(s3)
        if s3_len > n - len1 - len2 - start:
            return False
        if s3 == str[start + len1 + len2 : start + len1 + len2 + s3_len]:
            if start + len1 + len2 + s3_len == n:
                return True
            return self.check(str, start + len1, len2, s3_len, n)
        return False

    def isSumString(self, str):
        n = len(str)
        for i in range(1, n):
            for j in range(1, n - i):
                if self.check(str, 0, i, j, n):
                    return 1
        return 0
