class Solution {
    public int maxWater(List<Integer> arr) {
        if (arr.size() < 2) {
            return 0;
        }
        int left = 0;
        int right = arr.size() - 1;
        int max = 0;

        while (left < right) {
            int temp;
            if (arr.get(left) < arr.get(right)) {
                temp = arr.get(left);
            } else {
                temp = arr.get(right);
            }
            temp *= (right - left);
            max = Math.max(max, temp);

            if (arr.get(left) < arr.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
