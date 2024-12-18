

class Solution {
public:
    bool isPossible(vector<int>& arr, int n, int k, int maxPages) {
        int student_count = 1;
        int current_pages = 0;

        for (int pages : arr) {
            if (current_pages + pages > maxPages) {
                student_count++;
                current_pages = pages;

                if (student_count > k) {
                    return false;
                }
            } else {
                current_pages += pages;
            }
        }
        return true;
    }

    int findPages(vector<int>& arr, int k) {
        int n = arr.size();

        if (n < k) {
            return -1;
        }

        int low = *max_element(arr.begin(), arr.end());
        int high = accumulate(arr.begin(), arr.end(), 0);
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, n, k, mid)) {
                result = mid; // Update result and try for a smaller maximum
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
};
