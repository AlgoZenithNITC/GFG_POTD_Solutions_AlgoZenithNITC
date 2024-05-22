class Solution {
    public static double findSmallestMaxDist(int st[], int K) {
        // initialize variables
        int count, N = st.length;
        double left = 0, right = st[N - 1] - st[0], mid;

        // binary search to find the smallest maximum distance
        while (left + 1e-6 < right) {
            mid = (left + right) / 2;
            count = 0;

            // calculate the count by dividing the distance by the mid and
            // subtracting 1 from the result
            for (int i = 0; i < N - 1; ++i)
                count += Math.ceil((st[i + 1] - st[i]) / mid) - 1;

            // update left or right based on the count
            if (count > K)
                left = mid;
            else
                right = mid;
        }

        // return the smallest maximum distance
        return right;
    }
}
