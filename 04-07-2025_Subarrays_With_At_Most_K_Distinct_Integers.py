from collections import defaultdict

class Solution:
    def countAtMostK(self, arr, k):
        left = 0
        freq = defaultdict(int)
        ans = 0

        for right in range(len(arr)):
            if freq[arr[right]] == 0:
                k -= 1
            freq[arr[right]] += 1

            while k < 0:
                freq[arr[left]] -= 1
                if freq[arr[left]] == 0:
                    k += 1
                left += 1

            ans += (right - left + 1)

        return ans
