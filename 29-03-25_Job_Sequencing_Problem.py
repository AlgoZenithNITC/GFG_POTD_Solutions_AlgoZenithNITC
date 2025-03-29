class Solution:
    def jobSequencing(self, deadline, profit):
        n = len(deadline)
        ans = [0, 0]
    
        jobs = [(deadline[i], profit[i]) for i in range(n)]
      
        jobs.sort()
        
        pq = []
        
        for job in jobs:
            if job[0] > len(pq):
                heapq.heappush(pq, job[1])
            elif pq and pq[0] < job[1]:
                heapq.heappop(pq)
                heapq.heappush(pq, job[1])
        
        while pq:
            ans[1] += heapq.heappop(pq)
            ans[0] += 1
        
        return ans     
