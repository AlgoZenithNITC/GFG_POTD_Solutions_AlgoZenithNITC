class Solution:
    def rec(self, root, length, sum_val, max_length, max_sum):
        if root is None:
            return
        sum_val += root.data
        length += 1

        if length > max_length[0]:
            max_length[0] = length
            max_sum[0] = sum_val
        elif length == max_length[0]:
            if sum_val > max_sum[0]:
                max_sum[0] = sum_val

        self.rec(root.left, length, sum_val, max_length, max_sum)
        self.rec(root.right, length, sum_val, max_length, max_sum)

    def sumOfLongRootToLeafPath(self, root):
        max_length = [0]
        max_sum = [0]
        self.rec(root, 0, 0, max_length, max_sum)
        return max_sum[0]