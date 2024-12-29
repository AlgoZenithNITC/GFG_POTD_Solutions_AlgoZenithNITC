class Solution {
  public:
    vector<int> intersectionWithDuplicates(vector<int>& a, vector<int>& b) {
        // Step 1: Insert elements of array `a` into a set to remove duplicates.
        set<int> st(a.begin(), a.end());

        // Step 2: Sort array `b` for easier handling.
        sort(b.begin(), b.end());
        
        // Step 3: Declare a vector to store the result.
        vector<int> ans;

        // Step 4: Check elements of `b` for intersection.
        for (int x : b) {
            // If x is in the set and not already in the result, add it.
            if (st.find(x) != st.end() && !binary_search(ans.begin(), ans.end(), x)) {
                ans.push_back(x);
            }
        }

        // Step 5: Return the result. (Driver code will sort if needed.)
        return ans;
    }
};
