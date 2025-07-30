def cntSubarrays(self, arr: List[int], k: int) -> int:
    from collections import defaultdict

    mp = defaultdict(int)
    mp[0] = 1

    total = 0
    count = 0

    for num in arr:
        total += num
        count += mp[total - k]
        mp[total] += 1

    return count
