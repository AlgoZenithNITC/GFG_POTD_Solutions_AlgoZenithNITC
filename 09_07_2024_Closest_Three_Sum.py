
class Solution:
    def threeSumClosest(self, arr, target):
        arr.sort()
        n = len(arr)
        ans = float('inf')
        diff = float('inf')

        for i in range(n - 2):
            st, end = i + 1, n - 1
            while st < end:
                sum_ = arr[i] + arr[st] + arr[end]
                current_diff = abs(sum_ - target)
                if current_diff < diff or (current_diff == diff and sum_ > ans):
                    diff = current_diff
                    ans = sum_
                if sum_ < target:
                    st += 1
                elif sum_ > target:
                    end -= 1
                else:
                    return target
        return ans


