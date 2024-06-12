class Solution {
    public static int countNumberswith4(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (String.valueOf(i).contains("4")) {
                count++;
            }
        }
        return count;
    }
}
