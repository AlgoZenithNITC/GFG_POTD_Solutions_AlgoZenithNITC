from typing import List

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def help(arr: List[int], n: int, k: int, i: int, sum_: int, target_: List[int], ans: set[tuple[int]]) -> None:
            if sum_ == k:
                ans.add(tuple(target_))
                return
            if i == n:
                return
            help(arr, n, k, i + 1, sum_, target_, ans)
            if sum_ + arr[i] <= k:
                target_.append(arr[i])
                help(arr, n, k, i + 1, sum_ + arr[i], target_, ans)
                target_.pop()

        candidates.sort()
        target_ = []
        ans = set()
        help(candidates, len(candidates), target, 0, 0, target_, ans)
        return list(ans)

