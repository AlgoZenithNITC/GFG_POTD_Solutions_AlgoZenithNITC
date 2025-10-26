class Solution {
    long minCost(long arr[]) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long x : arr) pq.add(x);

        long cost = 0;
        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();
            cost += a + b;
            pq.add(a + b);
        }
        return cost;
    }
}
