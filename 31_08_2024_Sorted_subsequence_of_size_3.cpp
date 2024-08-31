// Function to find three numbers in the given array
// such that arr[smaller[i]] < arr[i] < arr[greater[i]]

class Solution {
  public:
    vector<int> find3Numbers(vector<int> arr) {
        int n = arr.size();
        int max = n - 1; // index of maximum element in the array
        int min = 0;     // index of minimum element in the array
        int i;

        int *smaller = new int[n];
        smaller[0] = -1; // first entry will always be -1
        // updating the smaller array by finding the index of
        // minimum element before the current element
        for (i = 1; i < n; i++) {
            if (arr[i] <= arr[min]) {
                min = i; // updating the index of minimum element
                smaller[i] = -1;
            } else {
                smaller[i] = min;
            }
        }

        int *greater = new int[n];
        greater[n - 1] = -1; // last entry will always be -1
        // updating the greater array by finding the index of
        // maximum element after the current element
        for (i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[max]) {
                max = i; // updating the index of maximum element
                greater[i] = -1;
            } else {
                greater[i] = max;
            }
        }

        vector<int> r; // vector to store the three numbers

        // iterating over the array to find the three numbers
        for (i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                // found the three numbers that satisfy the condition
                r.push_back(arr[smaller[i]]);
                r.push_back(arr[i]);
                r.push_back(arr[greater[i]]);
                return r; // returning the result
            }
        }

        delete[] smaller; // deallocating memory
        delete[] greater; // deallocating memory
        return r;         // if no three numbers are found, return an empty vector
    }
};
