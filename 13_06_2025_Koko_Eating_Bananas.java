class Solution {
    public int kokoEat(int[] arr, int k) {
        int left = 1;
        int right = 0;
        for (int bananas : arr) {
            right = Math.max(right, bananas);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (canFinish(arr, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] arr, int k, int speed) {
        int hours = 0;
        for (int bananas : arr) {
            hours += (bananas + speed - 1) / speed;
        }
        return hours <= k;
    }
}
