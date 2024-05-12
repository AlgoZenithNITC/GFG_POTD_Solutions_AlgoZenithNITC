#User function Template for python3

class Solution:
    def minSteps(self, d):
        # code here
        step = 0
        sum_ = 0
        while sum_ < d or (sum_ - d) % 2 != 0:
            step += 1
            sum_ += step
            
        return step
      
