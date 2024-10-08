//Back-end complete function Template for C++

class Solution {
  public:
    int pairsum(vector<int> &arr) {
        // code here
        // Initialize first and second largest element
        int n = arr.size();
        int first, second;
        if (arr[0] > arr[1]) {
            first = arr[0];
            second = arr[1];
        } else {
            first = arr[1];
            second = arr[0];
        }

        // Traverse remaining array and find first and second
        // largest elements in overall array
        for (int i = 2; i < n; i++) {
            /* If current element is greater than first then
              update both first and second */
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and second then
             * update second  */
            else if (arr[i] > second)
                second = arr[i];
        }
        return (first + second);
    }
};
