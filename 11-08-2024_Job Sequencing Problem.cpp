class Solution 
{
    public:
    //Function to find the maximum profit and the number of jobs done.
    class DSU {
    public:
        vector<int> parent;
    
        DSU(int N) {
            parent.resize(N + 1);
            for (int i = 0; i <= N; i++) {
                parent[i] = i;
            }
        }
    
        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    
        void unite(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX;
            }
        }
    };
    
    vector<int> JobScheduling(Job arr[], int N) {
        sort(arr, arr + N, [](Job a, Job b) { return a.profit > b.profit; });
    
        int maxDeadline = 0;
        for (int i = 0; i < N; i++) {
            maxDeadline = max(maxDeadline, arr[i].dead);
        }
    
        DSU dsu(100000); // Initialize DSU with a large value
    
        int profit = 0, jobsDone = 0;
    
        for (int i = 0; i < N; i++) {
            int availableSlot = dsu.find(arr[i].dead);
            if (availableSlot > 0) {
                dsu.unite(availableSlot - 1, availableSlot);
                profit += arr[i].profit;
                jobsDone++;
            }
        }
    
        return {jobsDone, profit};
    }

};
