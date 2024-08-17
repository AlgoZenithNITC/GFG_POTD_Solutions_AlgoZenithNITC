class Solution {
public:
    vector<long long int>
    productExceptSelf(vector<long long int>& nums)
    {
        
        int n = nums.size();

        if (n == 1) {
            return { 1 };
        }
        vector<long long> left(n), right(n);

        vector<long long> prod(n);

        int i, j;

        left[0] = 1;

        right[n - 1] = 1;

        for (i = 1; i < n; i++)
            left[i] = nums[i - 1] * left[i - 1];

        for (j = n - 2; j >= 0; j--)
            right[j] = nums[j + 1] * right[j + 1];

        for (i = 0; i < n; i++)
            prod[i] = left[i] * right[i];

        return prod;
    }
};
