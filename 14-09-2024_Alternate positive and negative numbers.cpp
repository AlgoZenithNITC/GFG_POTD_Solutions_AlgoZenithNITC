//Back-end complete function template for C++
class Solution {
  public:
    // Function to rearrange the array with negative numbers followed by positive
    // numbers.
    void rearrange(vector<int> &arr) {
        vector<int> neg, pos;
        int n = arr.size();
        // Separating negative and positive numbers into separate vectors.
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0)
                neg.push_back(arr[i]);
            else
                pos.push_back(arr[i]);
        }

        int i = 0, j = 0, k = 0;
        // Merging the negative and positive numbers alternatively.
        while (i < neg.size() && j < pos.size()) {
            arr[k++] = pos[j++];
            arr[k++] = neg[i++];
        }

        // Adding any remaining positive numbers to the array.
        while (j < pos.size()) {
            arr[k++] = pos[j++];
        }

        // Adding any remaining negative numbers to the array.
        while (i < neg.size()) {
            arr[k++] = neg[i++];
        }
    }
};
