#Back-end complete function Template for Python 3
class Solution:

    def is_leaf(self, node):
        if node is None:
            return True
        if node.left is None and node.right is None:
            return True
        return False

    def is_sum_tree(self, node):
        if node is None or self.is_leaf(node):
            return True

        if self.is_sum_tree(node.left) and self.is_sum_tree(node.right):
            ls = 0
            rs = 0

            if node.left is None:
                ls = 0
            elif self.is_leaf(node.left):
                ls = node.left.data
            else:
                ls = 2 * node.left.data

            if node.right is None:
                rs = 0
            elif self.is_leaf(node.right):
                rs = node.right.data
            else:
                rs = 2 * node.right.data

            return node.data == ls + rs

        return False
