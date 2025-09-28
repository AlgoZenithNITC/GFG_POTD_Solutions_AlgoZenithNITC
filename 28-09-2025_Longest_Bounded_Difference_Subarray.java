class Solution {
    public int[] longestSubarray(int[] arr, int x) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int l = 0, bl = 0, br = 0;
        int n = arr.length;

        for (int r = 0; r < n; r++) {
            // maintain max deque (decreasing)
            while (!maxd.isEmpty() && maxd.peekLast() < arr[r])
                maxd.pollLast();
            maxd.addLast(arr[r]);

            // maintain min deque (increasing)
            while (!mind.isEmpty() && mind.peekLast() > arr[r])
                mind.pollLast();
            mind.addLast(arr[r]);

            // shrink if invalid
            while (!maxd.isEmpty() && !mind.isEmpty() && maxd.peekFirst() - mind.peekFirst() > x) {
                if (arr[l] == maxd.peekFirst()) maxd.pollFirst();
                if (arr[l] == mind.peekFirst()) mind.pollFirst();
                l++;
            }

            // update best window
            if (r - l > br - bl) {
                br = r;
                bl = l;
            }
        }

        return Arrays.copyOfRange(arr, bl, br + 1);
    }
}
