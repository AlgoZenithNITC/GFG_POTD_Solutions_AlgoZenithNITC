def longestKSubstr(self, s, k):
    from collections import defaultdict

    mp = defaultdict(int)
    l = 0
    ans = -1

    for r in range(len(s)):
        mp[s[r]] += 1

        while len(mp) > k:
            mp[s[l]] -= 1
            if mp[s[l]] == 0:
                del mp[s[l]]
            l += 1

        if len(mp) == k:
            ans = max(ans, r - l + 1)

    return ans
