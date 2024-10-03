class Solution {
  public:
    // Function to find the majority elements in the array
    vector<int> findMajority(vector<int>& nums) {
        int n = nums.size();
        int num1 = 0, num2 = 0;
        int c1 = 0, c2 = 0;
        vector<int> res;

        // Finding the two most frequent numbers using Boyer-Moore algorithm
        for (auto x : nums) {
            if (x == num1)
                c1++;
            else if (x == num2)
                c2++;
            else if (c1 == 0) {
                num1 = x;
                c1++;
            } else if (c2 == 0) {
                num2 = x;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0, c2 = 0;
        // Counting the occurrences of num1 and num2
        for (auto x : nums) {
            if (x == num1)
                c1++;
            else if (x == num2)
                c2++;
        }
        // Checking if num1 and num2 are majority elements
        if (c1 > n / 3)
            res.push_back(num1);
        if (c2 > n / 3)
            res.push_back(num2);

        sort(res.begin(), res.end());
        // If no majority elements, add -1 to the result vector
        if (res.size() == 0)
            res.push_back(-1);
        return res;
    }
};
