
from typing import List


class Solution:
    def pairsum(self, arr : List[int]) -> int:
        # code here
        ele1=max(arr)
        arr.remove(ele1)
        ele2=max(arr)
        return ele1+ele2
