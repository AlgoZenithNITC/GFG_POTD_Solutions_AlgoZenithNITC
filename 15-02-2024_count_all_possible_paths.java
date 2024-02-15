
 class Solution {
    public int isPossible(int[][] paths) {
        for (int[] path : paths) {
            int sum = 0;
            for (int value : path) {
                sum += value;
            }
            if (sum % 2 != 0) {
                return 0;
            }
        }
        return 1;
    }
}
