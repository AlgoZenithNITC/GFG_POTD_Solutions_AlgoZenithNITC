import java.util.*;

class Solution {
    private void solve(Node root, int sum, int length, int[] maxsum, int[] maxlength) {
        if (root == null) {
            if (maxlength[0] == length) {
                maxsum[0] = Math.max(maxsum[0], sum);
            } else if (maxlength[0] < length) {
                maxsum[0] = sum;
                maxlength[0] = length;
            }
            return;
        }
        sum = sum + root.data;
        length = length + 1;
        solve(root.left, sum, length, maxsum, maxlength);
        solve(root.right, sum, length, maxsum, maxlength);
    }

    public int sumOfLongRootToLeafPath(Node root) {
        int sum = 0;
        int length = 0;
        int[] maxsum = new int[1];
        int[] maxlength = new int[1];
        solve(root, sum, length, maxsum, maxlength);
        return maxsum[0];
    }
}

