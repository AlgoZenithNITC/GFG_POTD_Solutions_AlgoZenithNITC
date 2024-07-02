class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Solution:
    def _is_palindrome(self, s):
        n = len(s)
        for i in range(n // 2):
            if s[i] != s[n - i - 1]:
                return False
        return True

    def _convert_to_string(self, head):
        temp = head
        s = ""
        while temp is not None:
            s += temp.data
            temp = temp.next
        return self._is_palindrome(s)

    def compute(self, head):
        return self._convert_to_string(head)
