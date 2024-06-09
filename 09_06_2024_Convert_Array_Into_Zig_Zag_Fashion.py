
from typing import List


class Solution:
    def zigZag(self, n : int, arr : List[int]) -> None:
        for i in range(n - 1):
            if (i % 2 == 0 and arr[i] > arr[i + 1]) or (i % 2 == 1 and arr[i] < arr[i + 1]):
                arr[i], arr[i + 1] = arr[i + 1], arr[i]

