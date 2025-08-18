class Solution {
    private boolean check(int[] arr, int H) {
        int count = 0;
        for (int x : arr) {
            if (x >= H) count++;
        }
        return count >= H;
    }

    public int hIndex(int[] citations) {
        int low = 1, high = 0;
        for (int c : citations) {
            high = Math.max(high, c);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(citations, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}
