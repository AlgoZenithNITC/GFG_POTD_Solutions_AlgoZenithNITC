class DSU:
    def __init__(self, N):
        self.parent = list(range(N + 1))

    def find(self, x):
        if x != self.parent[x]:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def unite(self, x, y):
        rootX = self.find(x)
        rootY = self.find(y)
        if rootX != rootY:
            self.parent[rootY] = rootX

class Solution:
    
    #Function to find the maximum profit and the number of jobs done.
    def JobScheduling(self,Jobs,N):
        Jobs.sort(key=lambda x: x.profit, reverse=True)

        maxDeadline = max(job.deadline for job in Jobs)

        dsu = DSU(100000)  # Initialize DSU with a large value

        profit = 0
        jobsDone = 0

        for job in Jobs:
            availableSlot = dsu.find(job.deadline)
            if availableSlot > 0:
                dsu.unite(availableSlot - 1, availableSlot)
                profit += job.profit
                jobsDone += 1

        return [jobsDone, profit]
