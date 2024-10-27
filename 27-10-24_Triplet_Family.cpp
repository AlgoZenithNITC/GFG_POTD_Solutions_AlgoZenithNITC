class Solution {
public:
    bool findTriplet(std::vector<int>& arr) {
        std::sort(arr.begin(), arr.end());  // Sort the array
        int n = arr.size();
        
        // Iterate through the array, treating each element as a potential third element
        for (int i = 0; i < n; i++) {
            int target = arr[i];
            std::unordered_set<int> seen;  // Set to track the numbers we need

            // Iterate through the array up to the current element
            for (int j = 0; j < i; j++) {
                int complement = target - arr[j];
                if (seen.find(complement) != seen.end()) {
                    // Triplet found
                    return true;  // Exit immediately after finding the first triplet
                }
                seen.insert(arr[j]);
            }
        }

        return false;  // No triplet found
    }
};