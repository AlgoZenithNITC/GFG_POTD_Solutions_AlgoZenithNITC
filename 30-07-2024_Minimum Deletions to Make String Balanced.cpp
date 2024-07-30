class Solution {
public:
    int minimumDeletions(string s) {
        int n = s.length();
        vector<int> count_a(n, 0);
        vector<int> count_b(n, 0);
        int b_count = 0;

        // First pass: compute count_b which stores the number of
        // 'b' characters to the left of the current position.
        for (int i = 0; i < n; i++) {
            count_b[i] = b_count;
            if (s[i] == 'b') b_count++;
        }

        int a_count = 0;
        // Second pass: compute count_a which stores the number of
        // 'a' characters to the right of the current position
        for (int i = n - 1; i >= 0; i--) {
            count_a[i] = a_count;
            if (s[i] == 'a') a_count++;
        }

        int min_deletions = n;
        // Third pass: iterate through the string to find the minimum deletions
        for (int i = 0; i < n; i++) {
            min_deletions = min(min_deletions, count_a[i] + count_b[i]);
        }

        return min_deletions;
    }
};
