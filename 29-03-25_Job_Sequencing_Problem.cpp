class Solution {
  public:
    vector<int> jobSequencing(vector<int> &deadline, vector<int> &profit) {
        int maxJobs = 0;
        int maxProfit = 0;
        int n = deadline.size();
        
        vector<pair<int,int>> jobs;
        for(int i=0; i<n; i++){
            jobs.push_back({deadline[i],profit[i]});
        }
        
        sort(jobs.begin(), jobs.end()); //ascending order
        
        
        priority_queue<int, vector<int>, greater<int>> pq;
        
        for(const auto &job : jobs){
            if (job.first > pq.size()){
                pq.push(job.second);
            } else if (!pq.empty() && pq.top() < job.second) {
                pq.pop();
                pq.push(job.second);
            }
        }
        
        while(!pq.empty()){
            maxProfit += pq.top();
            pq.pop();
            maxJobs++;
        }
        
        vector<int> res = {maxJobs,maxProfit};
        return res;
    }
};
