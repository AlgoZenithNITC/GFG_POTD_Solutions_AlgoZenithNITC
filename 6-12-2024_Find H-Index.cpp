// User function Template for C++
class Solution {
  public:
    // Function to find hIndex
    int hIndex(vector<int>& citations) {
        // code here   
        int n = citations.size();
        sort(citations.begin(), citations.end());
        int ans = 0;
        for(int i=0;i<citations.size();i++) {
            if(citations[i] <= n-i) {
                ans = max(ans,citations[i]);
            }
            else {
                ans = max(ans,n-i);
            }
        }
        return ans;
    }
};