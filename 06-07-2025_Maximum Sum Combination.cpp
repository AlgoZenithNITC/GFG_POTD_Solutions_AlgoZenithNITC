class Solution {
  public:
    vector<int> topKSumPairs(vector<int>& a, vector<int>& b, int k) {
        int n = a.size();

        // sort both arrays in descending order
        sort(a.rbegin(), a.rend());
        sort(b.rbegin(), b.rend());

        // max-heap to store {sum, {i, j}}
        priority_queue<pair<int, pair<int, int>>> pq;
        set<pair<int, int>> vis;

        // start from the largest possible pair (0,0)
        pq.push({a[0] + b[0], {0, 0}});
        vis.insert({0, 0});

        vector<int> res;

        while (res.size() < k) {
            auto top = pq.top();
            pq.pop();

            int sum = top.first;
            int i = top.second.first;
            int j = top.second.second;

            res.push_back(sum);

            // add next element in a if not visited
            if (i + 1 < n && vis.find({i + 1, j}) == vis.end()) {
                pq.push({a[i + 1] + b[j], {i + 1, j}});
                vis.insert({i + 1, j});
            }

            // add next element in b if not visited
            if (j + 1 < n && vis.find({i, j + 1}) == vis.end()) {
                pq.push({a[i] + b[j + 1], {i, j + 1}});
                vis.insert({i, j + 1});
            }
        }

        return res;
    }
};