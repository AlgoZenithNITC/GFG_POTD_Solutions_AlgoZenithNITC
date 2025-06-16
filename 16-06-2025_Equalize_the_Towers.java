class Solution {
    public long getTotalCost(int[] heights, int[] cost, int target) {
        long total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += 1L * Math.abs(heights[i] - target) * cost[i];
        }
        return total;
    }

    public int minCost(int[] heights, int[] cost) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        // Find min and max heights
        for (int h : heights) {
            low = Math.min(low, h);
            high = Math.max(high, h);
        }

        long answer = getTotalCost(heights, cost, heights[0]);

        // Binary search on target height
        while (low < high) {
            int mid = (low + high) / 2;
            long cost1 = getTotalCost(heights, cost, mid);
            long cost2 = getTotalCost(heights, cost, mid + 1);
            answer = Math.min(cost1, cost2);

            if (cost1 < cost2) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) getTotalCost(heights, cost, low);
    }
}
