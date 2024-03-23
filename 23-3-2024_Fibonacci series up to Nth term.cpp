//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    vector<int> Series(int n) {
        // Code here
         vector<int>ans;
        long long a=0;
        long long b=1;
        ans.push_back(a);
        ans.push_back(b);
        long long mod=1e9+7;
        for(int i=2;i<=n;i++){
            long long sum=(a+b)%mod;
            a=b;
            b=sum;
            ans.push_back(sum);
        }
        return ans;
    }
    };

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution obj;

        vector<int> ans = obj.Series(n);
        for (auto x : ans) cout << x << " ";
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends