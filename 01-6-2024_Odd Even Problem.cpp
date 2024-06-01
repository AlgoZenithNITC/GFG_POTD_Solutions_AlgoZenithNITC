//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    string oddEven(string s) {
        // code here
        int x = 0, y = 0;
        
        // Iterate over all characters from 'a' to 'z'
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int count = 0;
            
            // Count occurrences of the current character in the string
            for (char c : s) {
                if (c == ch) {
                    count++;
                }
            }
            
            // Determine the position of the character in the alphabet (1-indexed)
            int position = ch - 'a' + 1;
            
            // Check conditions for X and Y
            if (count > 0) {
                if (position % 2 == 0 && count % 2 == 0) {
                    x++;
                } else if (position % 2 != 0 && count % 2 != 0) {
                    y++;
                }
            }
        }
        
        // Determine if the sum of X and Y is even or odd
        if ((x + y) % 2 == 0) {
            return "EVEN";
        } else {
            return "ODD";
        }
    }
};



//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        string s;
        getline(cin, s);

        Solution obj;
        string res = obj.oddEven(s);

        cout << res << "\n";
    }
}

// } Driver Code Ends