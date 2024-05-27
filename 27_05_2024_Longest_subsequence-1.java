class Solution {

    public static int solve(int ind, int prev, int n,
                            int[] nums)
    {
        // Base case: If the index is beyond the array size,
        // return 0
        if (ind >= n) {
            return 0;
        }

        int take = 0, nottake = 0;

        // If the previous element is -1 or the absolute
        // difference is 1, consider taking the current
        // element
        if (prev == -1
            || Math.abs(nums[ind] - nums[prev]) == 1) {
            take = 1 + solve(ind + 1, ind, n, nums);
        }

        // Consider not taking the current element
        nottake = solve(ind + 1, prev, n, nums);

        // Return the maximum of taking or not taking the
        // current element
        return Math.max(take, nottake);
    }

    static int longestSubsequence(int N, int A[])
    {
        // code here
        return solve(0, -1, N, A);
    }
}
