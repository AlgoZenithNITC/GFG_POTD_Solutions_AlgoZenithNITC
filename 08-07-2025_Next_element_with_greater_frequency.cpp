using namespace std;

class Solution {
public:
    vector<int> findGreater(vector<int>& arr) {
        int n = arr.size();
        vector<int> res(n, -1);
        unordered_map<int, int> freq;
        stack<int> st;

        // Step 1: Count frequency
        for (int num : arr) {
            freq[num]++;
        }

        // Step 2: Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int currentFreq = freq[arr[i]];

            // Pop elements with freq <= currentFreq
            while (!st.empty() && freq[st.top()] <= currentFreq) {
                st.pop();
            }

            // If stack not empty, assign top
            if (!st.empty()) {
                res[i] = st.top();
            }

            // Push current element
            st.push(arr[i]);
        }

        return res;
    }
};
