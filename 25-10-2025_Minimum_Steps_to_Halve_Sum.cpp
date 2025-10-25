class Solution {
  public:
    int minOperations(vector<int>& arr) {
        // code here
        double sum = 0;
        priority_queue<double> pq;
        
        for (int x : arr) {
            sum += x;
            pq.push(x);
        }
        
        double target = sum / 2.0;
        double curr = sum;
        int count = 0;
        
        while (curr > target) {
            double x = pq.top(); pq.pop();
            double half = x / 2.0;
            curr -= half;
            pq.push(half);
            count++;
        }
        
        return count;
    }

};
