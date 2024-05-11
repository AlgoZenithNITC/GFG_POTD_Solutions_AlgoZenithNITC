//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    vector<long long> jugglerSequence(long long n) {
        // code here
        vector<long long> vec;
        long long s=n;
        
        while(s!=1){
            vec.push_back(s);
        if (s % 2 == 0) {
            s = std::sqrt(s);
        } else {
            s = std::sqrt(s) * std::sqrt(s) * std::sqrt(s);
        }
       
        }
        vec.push_back(1);
        return vec;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        long long n;
        cin >> n;

        Solution ob;
        vector<long long> ans = ob.jugglerSequence(n);
        for (long long u : ans)
            cout << u << " ";
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends