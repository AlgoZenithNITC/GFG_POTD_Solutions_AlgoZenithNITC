public class SearchRowMatrix {
    public static boolean searchRowMatrix(int[][] mat, int n, int m, int x) {
        for (int i = 0; i < n; i++) {
            int l = 0, r = m - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (mat[i][mid] == x) {
                    return true;
                } else if (mat[i][mid] > x) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}
