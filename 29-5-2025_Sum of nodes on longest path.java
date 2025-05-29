class Solution {
    public void rec(Node root, int length, int sum, int[] max_length, int[] max_sum) {
        if (root == null) {
            return;
        }
        sum += root.data;
        length++;

        if (length > max_length[0]) {
            max_length[0] = length;
            max_sum[0] = sum;
        } else if (length == max_length[0]) {
            if (sum > max_sum[0]) {
                max_sum[0] = sum;
            }
        }

        rec(root.left, length, sum, max_length, max_sum);
        rec(root.right, length, sum, max_length, max_sum);
    }

    public int sumOfLongRootToLeafPath(Node root) {
        int[] max_length = {0};
        int[] max_sum = {0};
        rec(root, 0, 0, max_length, max_sum);
        return max_sum[0];
    }
}
