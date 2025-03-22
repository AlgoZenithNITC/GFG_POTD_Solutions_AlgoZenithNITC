//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
  
    int find(vector<int>arr,int i,int n){
        int sum=0;
        for(int j=i;j<n;j+=2){
            sum+=arr[j];
        }
        return sum;
    }
  
    int maxValue(vector<int>& arr) {
        // your code here
        int n=arr.size();
        int w1=find(arr,0,n-1);
        int w2=find(arr,1,n);
        return (w1>w2)?w1:w2;
    }
};



//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        string input;
        int num;
        vector<int> arr;

        getline(cin, input);
        stringstream s2(input);
        while (s2 >> num) {
            arr.push_back(num);
        }

        Solution ob;
        int res;
        res = ob.maxValue(arr);
        cout << res << "\n"
             << "~" << endl;
    }

    return 0;
}

// } Driver Code Ends