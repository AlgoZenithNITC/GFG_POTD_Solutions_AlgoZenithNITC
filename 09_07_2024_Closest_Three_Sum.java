class Solution {
    static int threeSumClosest(int[] arr, int target) {
        // code here
        int diff = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int s = i + 1, e = arr.length - 1;
            while (s < e) {
                int sum = arr[i] + arr[s] + arr[e];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    e--;
                } else {
                    s++;
                }

                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    closestSum = sum;
                } else if (Math.abs(sum - target) == diff) {
                    closestSum = Math.max(closestSum, sum);
                }
            }
        }

        return closestSum;
    }
}
