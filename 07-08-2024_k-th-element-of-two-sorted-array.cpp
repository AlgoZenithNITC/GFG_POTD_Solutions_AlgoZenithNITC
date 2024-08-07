class Solution {
  public:
    // Method to find the kth element in two sorted arrays
    int kth(vector<int>& arr1, vector<int>& arr2, int s1, int e1, int s2, int e2,
            int k) {
        // Base case: If one array is empty, return kth element from the other array
        if (s1 == e1)
            return arr2[s2 + k];
        if (s2 == e2)
            return arr1[s1 + k];

        // Calculate the middle indices of the two arrays
        int m1 = (e1 - s1) / 2;
        int m2 = (e2 - s2) / 2;

        // If the sum of middle indices is less than k
        if (m1 + m2 < k) {
            // Compare the middle elements of the two arrays
            if (arr1[s1 + m1] > arr2[s2 + m2])
                // Recursively search in the second half of the second array
                return kth(arr1, arr2, s1, e1, s2 + m2 + 1, e2, k - m2 - 1);
            else
                // Recursively search in the second half of the first array
                return kth(arr1, arr2, s1 + m1 + 1, e1, s2, e2, k - m1 - 1);
        } else {
            // If the sum of middle indices is greater than or equal to k
            if (arr1[s1 + m1] > arr2[s2 + m2])
                // Recursively search in the first half of the first array
                return kth(arr1, arr2, s1, s1 + m1, s2, e2, k);
            else
                // Recursively search in the first half of the second array
                return kth(arr1, arr2, s1, e1, s2, s2 + m2, k);
        }
    }

    // Method to find the kth element in two sorted arrays
    int kthElement(int k, vector<int>& arr1, vector<int>& arr2) {
        // Call the recursive method to find the kth element
        int nn = arr1.size();
        int mm = arr2.size();
        return kth(arr1, arr2, 0, nn, 0, mm, k - 1);
    }
};
