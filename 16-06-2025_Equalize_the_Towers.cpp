class Solution {
  public:
    long long getTotalCost(const vector<int>& heights, const vector<int>& cost, int target) {
        long long total = 0;
        for (int i = 0; i < heights.size(); ++i) {
            total += 1LL * abs(heights[i] - target) * cost[i];
        }
        return total;
    }

    int minCost(vector<int>& heights, vector<int>& cost) {
        int low = *min_element(heights.begin(), heights.end());
        int high = *max_element(heights.begin(), heights.end());
        long long ans = getTotalCost(heights, cost, heights[0]);

        while (low < high) {
            int mid = (low + high) / 2;
            long long cost1 = getTotalCost(heights, cost, mid);
            long long cost2 = getTotalCost(heights, cost, mid + 1);
            ans = min(cost1, cost2);

            if (cost1 < cost2)
                high = mid;
            else
                low = mid + 1;
        }

        return (int)getTotalCost(heights, cost, low);
    }
};
