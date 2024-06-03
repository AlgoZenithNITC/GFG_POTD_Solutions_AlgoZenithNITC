#User function Template for python3
class Solution:
    def numberOfConsecutiveOnes (ob,n):
        # code here 
        mod = 1e9+7
        
        prevPrev, prev, prevAns = 0, 1, 1
        
        for i in range(3, n+1):
            add = (prevPrev + prev)%mod
            
            prevAns = (2 * prevAns + add)%mod
            
            prevPrev = prev
            prev = add
        
        return int(prevAns)
        
