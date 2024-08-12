class Solution:

    def sum_of_middle_elements(self, arr1, arr2):
        n = len(arr1)
        low, high = 0, n

        while low <= high:
            cut1 = (low + high) // 2
            cut2 = n - cut1

            l1 = float('-inf') if cut1 == 0 else arr1[cut1 - 1]
            l2 = float('-inf') if cut2 == 0 else arr2[cut2 - 1]
            r1 = float('inf') if cut1 == n else arr1[cut1]
            r2 = float('inf') if cut2 == n else arr2[cut2]

            if l1 <= r2 and l2 <= r1:
                return max(l1, l2) + min(r1, r2)
            elif l1 > r2:
                high = cut1 - 1
            else:
                low = cut1 + 1

        return 0  # This case will never occur for valid input
