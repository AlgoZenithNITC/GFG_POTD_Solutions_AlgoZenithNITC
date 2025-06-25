class Solution:
    def sameFreq(self, s: str) -> bool:
        freq = [0] * 26

        for c in s:
            freq[ord(c) - ord('a')] += 1

        if self.allSame(freq):
            return True

        for i in range(26):
            if freq[i] > 0:
                freq[i] -= 1

                if self.allSame(freq):
                    return True

                freq[i] += 1

        return False

    def allSame(self, freq: list[int]) -> bool:
        check = 0

        for i in range(26):
            if freq[i] > 0:
                check = freq[i]
                break

        for j in range(i + 1, 26):
            if freq[j] > 0 and freq[j] != check:
                return False

        return True
