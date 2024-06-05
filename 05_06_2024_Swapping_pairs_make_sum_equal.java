import java.util.HashSet;

class Solution {
    public int findSwapValues(int[] a, int n, int[] b, int m) {
        int a_sum = 0;
        for (int num : a) {
            a_sum += num;
        }
        int b_sum = 0;
        for (int num : b) {
            b_sum += num;
        }
        if ((a_sum - b_sum) % 2 != 0) {
            return -1;
        }
        int diff = (a_sum - b_sum) / 2;
        HashSet<Integer> a_set = new HashSet<>();
        for (int num : a) {
            a_set.add(num);
        }
        for (int num : b) {
            if (a_set.contains(num + diff)) {
                return 1;
            }
        }
        return -1;
    }
}

