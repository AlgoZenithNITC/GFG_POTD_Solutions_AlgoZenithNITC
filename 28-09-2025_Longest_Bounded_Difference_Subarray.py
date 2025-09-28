from collections import deque
class Solution:
    def longestSubarray(self, arr, x):
        mind,maxd=deque(),deque()
        l=bl=br=0
        n=len(arr)
        for r in range(n):
            while maxd and maxd[-1]<arr[r]:
                maxd.pop()
            maxd.append(arr[r])
            
            while mind and mind[-1]>arr[r]:
                mind.pop()
            mind.append(arr[r])
            
            while maxd[0]-mind[0]>x:
                if arr[l] == maxd[0]:
                    maxd.popleft()
                if arr[l] == mind[0]:
                    mind.popleft()
                l+=1
            if r-l>br-bl:
                br,bl=r,l
        return arr[bl:br+1]
