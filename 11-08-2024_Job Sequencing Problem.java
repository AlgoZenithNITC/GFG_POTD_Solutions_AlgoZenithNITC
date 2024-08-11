class DSU {
    int[] parent;

    DSU(int N) {
        parent = new int[N + 1];
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
}


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int N)
    {
        // Your code here
         Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (int i = 0; i < N; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }

        DSU dsu = new DSU(100000); // Initialize DSU with a large value

        int profit = 0, jobsDone = 0;

        for (int i = 0; i < N; i++) {
            int availableSlot = dsu.find(arr[i].deadline);
            if (availableSlot > 0) {
                dsu.unite(availableSlot - 1, availableSlot);
                profit += arr[i].profit;
                jobsDone++;
            }
        }

        return new int[]{jobsDone, profit};
    }
}
