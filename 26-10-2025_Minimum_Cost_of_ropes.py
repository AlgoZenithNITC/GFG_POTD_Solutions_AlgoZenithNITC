class Solution:
   def minCost(self, arr):
    # code here
    heapq.heapify(arr)
    cost=0
    while len(arr)>1:
        a=heapq.heappop(arr)
        b=heapq.heappop(arr)
        cost+=a+b
        heapq.heappush(arr,a+b)
    return cost        
        
